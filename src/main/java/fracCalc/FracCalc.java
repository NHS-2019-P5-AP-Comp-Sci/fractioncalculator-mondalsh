/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static int produceAnswer(String input) {
		// Scanner s = new Scanner(input);
		// String firstOperand = s.next();

		// String operator = s.next();
		// String secondOperand = s.next();

		// return secondOperand;
		String wow = input;
		String operand1 = wow.substring(0, wow.indexOf(' '));
		// wow = wow.substring(wow.indexOf(' ') + 1);
		String operator = wow.substring(wow.indexOf(' ') + 1, wow.indexOf(" ") + 2);
		// wow = wow.substring(wow.indexOf(' ') + 1);
		String operand2 = wow.substring(wow.indexOf(" ") + 3);
		String whole1 = operand1;
		String numerator1 = "0";
		String denominator1 = "1";
		if (whole1.indexOf("/") != -1) {
			if (operand1.indexOf("_") != -1) {
				whole1 = operand1.substring(0, operand1.indexOf("_"));
			} else {
				whole1 = "0";
			}
			numerator1 = operand1.substring(operand1.indexOf("_") + 1, operand1.indexOf("/"));
			denominator1 = operand1.substring(operand1.indexOf("/") + 1, operand1.length());
		}
		// String whole2 = operand2;
		String numerator2 = "0";
		String denominator2 = "1";
		if (operand2.indexOf("/") != -1) {
			if (operand2.indexOf("_") != -1) {
				// whole2 = operand2.substring(0, operand2.indexOf("_"));
			} else {
				// whole2 = "0";
			}
			numerator2 = operand2.substring(operand2.indexOf("_") + 1, operand2.indexOf("/"));
			denominator2 = operand2.substring(operand2.indexOf("/") + 1, operand2.length());

		}
		if (operator == "+") {
			add(numerator1, operator, denominator1, numerator2, denominator2);
		}
		if (operator.equals("-")) {
			sub(numerator1, operator, denominator1, numerator2, denominator2);
		}
		if (operator.equals("x")) {
			multi(numerator1, operator, denominator1, numerator2, denominator2);
		}
		if (operator.contentEquals("/")) {
			div(numerator1, operator, denominator1, numerator2, denominator2);
		}

		int result = Integer.valueOf(numerator2);
		return result;
	}
//		//String op2whole = findWhole(operand2);
	// String op2num = findNum(operand2);
//		//String op2denom = findDenom(operand2);

	// String chk2Answer = op2whole + op2num + op2denom;

	// return chk2Answer;
	// num2 = wow.substring(wow.indexOf("_")+1, wow.indexOf("/"));

	public static String findWhole(String str) {
		if (str.contains("_")) {
			return str.substring(0, str.indexOf('_'));
		} else if (str.contains("/")) {
			return "0";

		} else
			return str;

	}

	public static String findNum(String str) {
		if (str.contains("_")) {
			return str.substring(str.indexOf('_') + 1, str.indexOf('/'));
		} else if (str.contains("/")) {
			return str.substring(0, str.indexOf('/'));
		} else {
			return "0";
		}
	}

	public static String findDenom(String str) {
		if (str.contains("/")) {
			return str.substring(str.indexOf("/") + 1);
		} else {
			return "1";
		}
	}

	/*
	 * public static void add(int a1, int b1, int a2, int b2) { String reduced =
	 * reduce((a1 + a2), (b1 + b2)); System.out.println(reduced); }
	 * 
	 * public static void substract(int a1, int b1, int a2, int b2) { String reduced
	 * = reduce((a1 - a2), (b1 - b2)); System.out.println(reduced); }
	 * 
	 * public static void multiply(int a1, int b1, int a2, int b2) { String reduced
	 * = reduce((a1 * a2), (b1 * b2)); System.out.println(reduced); }
	 * 
	 * public static void divide(int a1, int b1, int a2, int b2) { String reduced =
	 * reduce((a1 * b2), (b1 * a2)); System.out.println(reduced); }
	 * 
	 * public static int rd(int top, int bot) { int temp; while (top != 0 && bot !=
	 * 0) { temp = bot; bot = top % bot; top = temp; } return Math.abs(top + bot);
	 * 
	 * }
	 * 
	 * public static String reduce(int t, int b) { int rd = rd(t, b); t = t / rd; b
	 * = b / rd; return t + "/" + b; }
	 */
	public static void div(String num1, String op1, String dom1, String num2, String dom2) {
		// int Num = Integer.parseInt(num1);
		// int Dom = Integer.parseInt(dom1);
		int Num2 = Integer.parseInt(num2);
		int Dom2 = Integer.parseInt(dom2);
		int tempInt;
		tempInt = Num2;
		Num2 = Dom2;
		Dom2 = tempInt;
		num1 = Integer.toString(Num2);
		dom1 = Integer.toString(Dom2);

		multi(num1, op1, dom1, num2, dom2);
	}

	public static String multi(String num1, String op1, String dom1, String num2, String dom2) {
		int Num = Integer.parseInt(num1);
		int Dom = Integer.parseInt(dom1);
		int Num2 = Integer.parseInt(num2);
		int Dom2 = Integer.parseInt(dom2);
		int numAnswer = Num * Num2;
		int domAnswer = Dom * Dom2;
		String ans = Integer.toString(numAnswer) + Integer.toString(domAnswer);
		return ans;
	}

	public static String sub(String num1, String op1, String dom1, String num2, String dom2) {
		int Num = Integer.parseInt(num1);
		int Dom = Integer.parseInt(dom1);
		int Num2 = Integer.parseInt(num2);
		int Dom2 = Integer.parseInt(dom2);
		int commondenom = Dom * Dom2;
		if (Dom != Dom2) {
			Dom = commondenom;
			Dom2 = commondenom;
		}
		int answer = Num - Num2;
		String ans = Integer.toString(answer) + Integer.toString(commondenom);
		return ans;
	}

	public static String add(String num1, String op1, String dom1, String num2, String dom2) {
		int Num = Integer.parseInt(num1);
		int Dom = Integer.parseInt(dom1);
		int Num2 = Integer.parseInt(num2);
		int Dom2 = Integer.parseInt(dom2);
		int commondenom = Dom * Dom2;
		if (Dom != Dom2) {
			Dom = commondenom;
			Dom2 = commondenom;
		}
		int answer = Num + Num2;
		String ans = Integer.toString(answer) + Integer.toString(commondenom);
		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String userResponce = s.nextLine();
		String userResponse = s.nextLine();
		while (!userResponse.equalsIgnoreCase("quit")) {
			System.out.println((produceAnswer(userResponce)));

		}
		s.close();

	}

}
