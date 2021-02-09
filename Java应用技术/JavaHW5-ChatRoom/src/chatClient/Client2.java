package chatClient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
/**
 * 
 * FileName: Client2.java
 * 
 * Client code
 *
 * 
 * 
 * @author neko
 * @Date 01/19/2021
 * 
 * @version 2.01
 * 
 */


public class Client2 extends JFrame {
    private JTextArea sendArea, contentArea;//Send message area, display message area
    JPanel p1, p11, p12, p2, p21, p22;
    private JPanel contentPane;
    JComboBox<String> userLog, userOnline;//Login user. online user
    private RecvThread clientThread = null;
    private String filePath = null;
    private JTextField textField;
    
    public static void main(String args[]) {
    	//Render UI
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
        	System.out.println(e);
        }
        try {
        	Client2 frame = new Client2();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    //UI
    public Client2() {
        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
        contentPane.setLayout(null);
        setContentPane(contentPane);
        setResizable(false);
        setTitle("������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
        
        JLabel lbl_uname = new JLabel("\u5F53\u524D\u7528\u6237");
        lbl_uname.setFont(new Font("����", Font.PLAIN, 24));
        lbl_uname.setBounds(825, 520, 138, 31);
        contentPane.add(lbl_uname);
        
        JLabel lblNewLabel = new JLabel("\u63A5\u53D7\u65B9");
        lblNewLabel.setFont(new Font("����", Font.PLAIN, 24));
        lblNewLabel.setBounds(825, 10, 106, 31);
        contentPane.add(lblNewLabel);
		
		sendArea = new JTextArea();
		sendArea.setFont(new Font("Monospaced", Font.PLAIN, 24));
        sendArea.setBounds(10, 520, 800, 219);
        contentPane.add(sendArea);
        sendArea.setLineWrap(true);
        sendArea.setWrapStyleWord(true);//Activate line break and continuous word function
        sendArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ('\n' == e.getKeyCode())//press Enter key
                    if (clientThread != null) {
                        clientThread.sendMsg();
                    }
            }
        });
        
        contentArea = new JTextArea();
        contentArea.setFont(new Font("Monospaced", Font.PLAIN, 24));
        contentArea.setBounds(10, 10, 800, 500);
        contentPane.add(contentArea);
        
        userLog = new JComboBox<>();
        userLog.setFont(new Font("����", Font.PLAIN, 24));
        userLog.setBounds(825, 552, 128, 31);
        contentPane.add(userLog);
        userLog.addItem("��ѡ��");
        userLog.addItem("С��");
        userLog.addItem("С��");
        userLog.addItem("Сè");
        userLog.addItem("С��");
        userLog.addItem("С��");
        userLog.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("ѡ�е��" + userLog.getSelectedItem());//debug��
                if (userLog.getSelectedIndex() == 0) {
                    return;
                }
                clientThread = new RecvThread((String) userLog.getSelectedItem());//Get login user info
                new Thread(clientThread).start();
            }
        });
        
        userOnline = new JComboBox<>();
        userOnline.setFont(new Font("����", Font.PLAIN, 24));
        userOnline.setBounds(825, 50, 128, 31);
        contentPane.add(userOnline);
		userOnline.addItem("�����û�");
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (clientThread != null)
                    clientThread.exit();
                System.exit(0);
            }
        });
    }

    private class RecvThread implements Runnable {
        private Socket s = null;
        private DataInputStream in = null;
        private DataOutputStream out = null;
        private String userName;
        private boolean isLogin = false;
        StringBuilder msg = new StringBuilder();

        public RecvThread(String userName) {
            this.userName = userName;
        }

        //Log
        public void login() {
            try {
                s = new Socket("127.0.0.1", 8888);//Monitor port 8888 of the host
                in = new DataInputStream(s.getInputStream());
                out = new DataOutputStream(s.getOutputStream());
                String sendMsg = "LOGIN#" + userName;
                out.writeUTF(sendMsg);
                out.flush();
                //Information returned by the server
                String recv = in.readUTF();
                if (recv.equals("FAIL")) {//If the user is already in the Client2
                    showMsg("���û��ѵ�¼��");
                    userLog.setEnabled(true);
                    exit();
                    return;
                } else if (recv.equals("SUCCESS")) {
                    showMsg("��¼�ɹ���");
                    userLog.setEnabled(false);
                    isLogin = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void exit() {//User exits, release resources
            try {
                if (isLogin) {
                    out.writeUTF("LOGOUT");
                    out.flush();
                    isLogin = false;
                }
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
                if (s != null)
                    s.close();

            } catch (IOException e) {
                System.out.println("�����ѹر�!");
            }
        }

        //�û�������Ϣ
        public void sendMsg() {
            int len = 0;
            if (!isLogin) {
                showMsg("û�е�¼,���¼��");
                return;
            }
            msg.setLength(0);
            String sendInfo = sendArea.getText().trim();
            String user = (String) userOnline.getSelectedItem();
            if(sendInfo.equals(""))
                sendInfo=" ";
            try {
                if (user.equals("�����û�")) {//send messages to all users
					msg.append("SENDALL#");
					msg.append(sendInfo);
                } 
                else if(user.equals(userName))
                	showMsg("ϵͳ��ʾ: �벻Ҫ�������");
                else {
                	msg.append("SENDONE#");
                    msg.append(user+"#" + sendInfo);
                }
                out.writeUTF(msg.toString());
                showMsg("��˵��" + sendInfo);
                sendArea.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            login();
            try {
                while (isLogin) {
                    String msgs[] = in.readUTF().split("#");
                    switch (msgs[0]) {
                        case "LOGIN":
                            userOnline.addItem(msgs[1]);//add online user
                            break;
                        case "ALLUSERS":
                            for (int i = 1; i < msgs.length; i++) {
                                if (!"".equals(msgs[i]))
                                    userOnline.addItem(msgs[i]);
                            }
                            break;
                        case "SENDONE":
                                showMsg(msgs[1] + ": " + msgs[2]);
                            break;
                        case "SENDALL":
                                showMsg(msgs[1] + "(����): " + msgs[2]);
                            break;
                        case "LOGOUT":
                            showMsg("�û�" + msgs[1] + "������");
                            userOnline.removeItem(msgs[1]);
                            break;
                    }
                }
            } catch (SocketException e) {
                System.out.println(userName + "���˳�...");
            } catch (IOException e) {
                isLogin = false;//Return data is abnormal, log out
                e.printStackTrace();
            }
        }
    }

    //show message
    public void showMsg(String msg) {
    	contentArea.append(msg + "\n");
        contentArea.setCaretPosition(contentArea.getText().length());//Automatically scroll to the last line of the text area
    }
}


