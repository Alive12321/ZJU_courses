package MatchstickGame;

import java.util.*;
import java.util.ArrayList;

public class MyMatchstick {

	public static String correctAnswer;
	public static String equation;
	public static ArrayList<ArrayList<String>> addMatchstick = new ArrayList<ArrayList<String>>();
	public static ArrayList<ArrayList<String>> subMatchstick = new ArrayList<ArrayList<String>>();
	public static ArrayList<String> addMatchstickZero = new ArrayList<String>();
	public static ArrayList<String> addMatchstickOne = new ArrayList<String>();
	public static ArrayList<String> addMatchstickTwo = new ArrayList<String>();
	public static ArrayList<String> addMatchstickThree = new ArrayList<String>();
	public static ArrayList<String> addMatchstickFour = new ArrayList<String>();
	public static ArrayList<String> addMatchstickFive = new ArrayList<String>();
	public static ArrayList<String> addMatchstickSix = new ArrayList<String>();
	public static ArrayList<String> addMatchstickSeven = new ArrayList<String>();
	public static ArrayList<String> addMatchstickEight = new ArrayList<String>();
	public static ArrayList<String> addMatchstickNine = new ArrayList<String>();
	public static ArrayList<String> addMatchstickAdd = new ArrayList<String>();
	public static ArrayList<String> addMatchstickSub = new ArrayList<String>();

	public static ArrayList<String> subMatchstickZero = new ArrayList<String>();
	public static ArrayList<String> subMatchstickOne = new ArrayList<String>();
	public static ArrayList<String> subMatchstickTwo = new ArrayList<String>();
	public static ArrayList<String> subMatchstickThree = new ArrayList<String>();
	public static ArrayList<String> subMatchstickFour = new ArrayList<String>();
	public static ArrayList<String> subMatchstickFive = new ArrayList<String>();
	public static ArrayList<String> subMatchstickSix = new ArrayList<String>();
	public static ArrayList<String> subMatchstickSeven = new ArrayList<String>();
	public static ArrayList<String> subMatchstickEight = new ArrayList<String>();
	public static ArrayList<String> subMatchstickNine = new ArrayList<String>();
	public static ArrayList<String> subMatchstickAdd = new ArrayList<String>();
	public static ArrayList<String> subMatchstickSub = new ArrayList<String>();

	public static void main(String[] args) {
		String nextQuestion;
		do {
			Scanner input = new Scanner(System.in);
			int digit, digitNum, type, matchNum;// �������֣��Ⱥ���ʽ���ָ�������Ŀ���ͣ�������
			do {
				System.out.print("����������ֵ�λ������1λ����2λ����3λ������");
				digit = input.nextInt();
			} while (digit != 1 && digit != 2 && digit != 3);
			do {
				System.out.print("������ʾ����2��3������ʾ�Ⱥ���ʽ���ֵĸ�����");
				digitNum = input.nextInt();
			} while (digitNum != 2 && digitNum != 3);
			do {
				System.out.print("������Ŀ���ͱ�ţ�1�ƶ���2�Ƴ���3��ӣ����Լ���������:");
				type = input.nextInt();
				matchNum = input.nextInt();
			} while (type != 1 && type != 2 && type != 3);

			initialize();
			question(digit, digitNum, type, matchNum);// ������Ŀ
			if (type == 1) {// �ƶ�=�ȼӺ��
				changeQuestion(1, matchNum);
				changeQuestion(2, matchNum);
			} else if (type == 2)
				changeQuestion(1, matchNum);
			else
				changeQuestion(2, matchNum);
			System.out.println(equation);

			System.out.print("����𰸣�");
			String answer;
			answer = input.nextLine();
			answer = input.nextLine();
			if (answer.equals(""))
				System.out.println(correctAnswer);
			else {
				while (!answer.equals(correctAnswer)) {
					System.out.println("����");
					System.out.print("����𰸣�");
					if (answer.equals("")) {
						System.out.println(correctAnswer);
						break;
					}
					answer = input.nextLine();
				}
				if (answer.equals(correctAnswer))
					System.out.println("��ȷ");
			}
			System.out.println("����������������롮q������");
			nextQuestion = input.nextLine();
		} while (!nextQuestion.equals("q"));
	}

	public static void initialize() {
		addMatchstickZero.add("8");
		addMatchstickZero.add("*");
		addMatchstickZero.add("*");
		addMatchstickZero.add("*");
		addMatchstickZero.add("*");
		addMatchstick.add(addMatchstickZero);
		addMatchstickOne.add("7");
		addMatchstickOne.add("4");
		addMatchstickOne.add("3");
		addMatchstickOne.add("09");
		addMatchstickOne.add("8");
		addMatchstick.add(addMatchstickOne);
		addMatchstickTwo.add("*");
		addMatchstickTwo.add("8");
		addMatchstickTwo.add("*");
		addMatchstickTwo.add("*");
		addMatchstickTwo.add("*");
		addMatchstick.add(addMatchstickTwo);
		addMatchstickThree.add("9");
		addMatchstickThree.add("8");
		addMatchstickThree.add("*");
		addMatchstickThree.add("*");
		addMatchstickThree.add("*");
		addMatchstick.add(addMatchstickThree);
		addMatchstickFour.add("*");
		addMatchstickFour.add("9");
		addMatchstickFour.add("8");
		addMatchstickFour.add("*");
		addMatchstickFour.add("*");
		addMatchstick.add(addMatchstickFour);
		addMatchstickFive.add("69");
		addMatchstickFive.add("8");
		addMatchstickFive.add("*");
		addMatchstickFive.add("*");
		addMatchstickFive.add("*");
		addMatchstick.add(addMatchstickFive);
		addMatchstickSix.add("8");
		addMatchstickSix.add("*");
		addMatchstickSix.add("*");
		addMatchstickSix.add("*");
		addMatchstickSix.add("*");
		addMatchstick.add(addMatchstickSix);
		addMatchstickSeven.add("*");
		addMatchstickSeven.add("3");
		addMatchstickSeven.add("09");
		addMatchstickSeven.add("8");
		addMatchstickSeven.add("*");
		addMatchstick.add(addMatchstickSeven);
		addMatchstickEight.add("*");
		addMatchstickEight.add("*");
		addMatchstickEight.add("*");
		addMatchstickEight.add("*");
		addMatchstickEight.add("*");
		addMatchstick.add(addMatchstickEight);
		addMatchstickNine.add("8");
		addMatchstickNine.add("*");
		addMatchstickNine.add("*");
		addMatchstickNine.add("*");
		addMatchstickNine.add("*");
		addMatchstick.add(addMatchstickNine);
		addMatchstickAdd.add("*");
		addMatchstickAdd.add("*");
		addMatchstickAdd.add("*");
		addMatchstickAdd.add("*");
		addMatchstickAdd.add("*");
		addMatchstick.add(addMatchstickAdd);
		addMatchstickSub.add("+");
		addMatchstickSub.add("*");
		addMatchstickSub.add("*");
		addMatchstickSub.add("*");
		addMatchstickSub.add("*");
		addMatchstick.add(addMatchstickSub);

		subMatchstickZero.add("*");
		subMatchstickZero.add("*");
		subMatchstickZero.add("7");
		subMatchstickZero.add("1");
		subMatchstickZero.add("*");
		subMatchstick.add(subMatchstickZero);
		subMatchstickOne.add("*");
		subMatchstickOne.add("*");
		subMatchstickOne.add("*");
		subMatchstickOne.add("*");
		subMatchstickOne.add("*");
		subMatchstick.add(subMatchstickOne);
		subMatchstickTwo.add("*");
		subMatchstickTwo.add("*");
		subMatchstickTwo.add("*");
		subMatchstickTwo.add("*");
		subMatchstickTwo.add("*");
		subMatchstick.add(subMatchstickTwo);
		subMatchstickThree.add("*");
		subMatchstickThree.add("7");
		subMatchstickThree.add("1");
		subMatchstickThree.add("*");
		subMatchstickThree.add("*");
		subMatchstick.add(subMatchstickThree);
		subMatchstickFour.add("*");
		subMatchstickFour.add("1");
		subMatchstickFour.add("*");
		subMatchstickFour.add("*");
		subMatchstickFour.add("*");
		subMatchstick.add(subMatchstickFour);
		subMatchstickFive.add("*");
		subMatchstickFive.add("*");
		subMatchstickFive.add("*");
		subMatchstickFive.add("*");
		subMatchstickFive.add("*");
		subMatchstick.add(subMatchstickFive);
		subMatchstickSix.add("5");
		subMatchstickSix.add("*");
		subMatchstickSix.add("7");
		subMatchstickSix.add("1");
		subMatchstickSix.add("*");
		subMatchstick.add(subMatchstickSix);
		subMatchstickSeven.add("1");
		subMatchstickSeven.add("*");
		subMatchstickSeven.add("*");
		subMatchstickSeven.add("*");
		subMatchstickSeven.add("*");
		subMatchstick.add(subMatchstickSeven);
		subMatchstickEight.add("069");
		subMatchstickEight.add("235");
		subMatchstickEight.add("4");
		subMatchstickEight.add("7");
		subMatchstickEight.add("1");
		subMatchstick.add(subMatchstickEight);
		subMatchstickNine.add("35");
		subMatchstickNine.add("4");
		subMatchstickNine.add("7");
		subMatchstickNine.add("1");
		subMatchstickNine.add("*");
		subMatchstick.add(subMatchstickNine);
		subMatchstickAdd.add("-");
		subMatchstickAdd.add("*");
		subMatchstickAdd.add("*");
		subMatchstickAdd.add("*");
		subMatchstickAdd.add("*");
		subMatchstick.add(subMatchstickAdd);
		subMatchstickSub.add("*");
		subMatchstickSub.add("*");
		subMatchstickSub.add("*");
		subMatchstickSub.add("*");
		subMatchstickSub.add("*");
		subMatchstick.add(subMatchstickSub);
	}

	public static void question(int digit, int digitNum, int type, int matchNum) {
		int max, min1, min2;// ��ʽ����������
		max = (int) (Math.random() * Math.pow(10, digit));
		min1 = (int) (Math.random() * max);
		min2 = max - min1;
		// ���ԭʼ����ȷ��ʽ
		if (digitNum == 2) {
			if (Math.random() > 0.5)
				correctAnswer = min1 + "+" + min2 + "=" + max;// min1+min2=max
			else
				correctAnswer = max + "-" + min1 + "=" + min2;// max-min1=min2
		} else if (digitNum == 3) {
			if (Math.random() > 0.5) {
				int min3 = (int) (Math.random() * min2);
				min2 = min2 - min3;
				if (Math.random() > 0.5)
					correctAnswer = min1 + "+" + min2 + "+" + min3 + "=" + max;// min1+min2+min3=max
				else
					correctAnswer = max + "-" + min2 + "-" + min3 + "=" + min1;// max-min2-min3=min1
			} else {
				int max1 = (int) (Math.random() * max);
				int max2 = max - max1;
				if (Math.random() > 0.5)
					correctAnswer = max1 + "+" + max2 + "-" + min1 + "=" + min2;// max1+max2-min1=min2
				else
					correctAnswer = max1 + "-" + min1 + "+" + max2 + "=" + min2;// max1-min1+max2=min2
			}
		}
		equation = correctAnswer;
	}

	public static void changeQuestion(int type, int matchNum) {
		int equationIndex;// ��ʽ�б�ѡ��Ҫ�޸ĵ����ֻ����
		int changeNum;// �޸ĵĻ�������
		char changeNow;// ��ǰ���޸ĵ����ֻ����
		int changeIndex;// ��ǰ���޸ĵ����ֻ���Ŵ���ArrayList�е�λ��
		String changeTo;// ���޸ĺ�����ֻ����

		while (matchNum > 0) {
			equationIndex = (int) (Math.random() * correctAnswer.length());// ���ѡȡ��ʽ��һ�����ֻ���Ž����޸�
			changeNow = correctAnswer.charAt(equationIndex);
			if (changeNow == '=')
				continue;// ���ѡȡ����=��������ѡȡ
			if (changeNow == '+')
				changeIndex = 10;
			else if (changeNow == '-')
				changeIndex = 11;
			else
				changeIndex = (int) changeNow - '0';
			changeNum = (int) (Math.random() * Math.min(5, matchNum));
			if (type == 1) {// ���ӻ���
				if (addMatchstick.get(changeIndex).get(changeNum) == "*")
					continue;
				if (addMatchstick.get(changeIndex).get(changeNum).length() != 1) {// ���޸ĺ�õ������ֲ�Ψһʱ
					int changeToIndex;
					changeToIndex = (int) (Math.random() * addMatchstick.get(changeIndex).get(changeNum).length());
					changeTo = addMatchstick.get(changeIndex).get(changeNum).substring(changeToIndex,
							changeToIndex + 1);
				} else
					changeTo = addMatchstick.get(changeIndex).get(changeNum);
			} else {
				if (subMatchstick.get(changeIndex).get(changeNum) == "*")
					continue;
				if (subMatchstick.get(changeIndex).get(changeNum).length() != 1) {// ���޸ĺ�õ������ֲ�Ψһʱ
					int changeToIndex;
					changeToIndex = (int) (Math.random() * subMatchstick.get(changeIndex).get(changeNum).length());
					changeTo = subMatchstick.get(changeIndex).get(changeNum).substring(changeToIndex,
							changeToIndex + 1);
				} else
					changeTo = subMatchstick.get(changeIndex).get(changeNum);
			}
			equation = equation.substring(0, equationIndex) + changeTo + equation.substring(equationIndex + 1);
			matchNum -= (changeNum + 1);
		}
	}
}