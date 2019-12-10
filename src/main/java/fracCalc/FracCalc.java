/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {
	public static String produceAnswer(String input) {
		/*
		 * String wow = input; String operand1 = wow.substring(0, wow.indexOf(' ')); wow
		 * = wow.substring(wow.indexOf(' ') + 1); String operator = wow.substring(0,
		 * wow.indexOf(' ')); wow = wow.substring(wow.indexOf(' ') + 1); String operand2
		 * = wow.substring(0);
		 */
		int space = input.indexOf(' ');
		if (space < 0) {
			return ("not statement");
		} else {

			int leftNum;
			int leftDenom;
			int middleNum;
			int middleDenom;
			int rightNum = 0;
			int rightDenom = 0;
			String leftOperator = null;
			String rightOperator = null;

			/*
			 * String token = getToken(input); input = removeToken(input);
			 * parseFraction(token); leftNum = outNum; leftDenom = outDenom; token =
			 * getToken(input); input = removeToken(input); parseFraction(token); middleNum
			 * = outNum; middleDenom = outDenom; boolean moreOperations = false; boolean
			 * calcOK = false;
			 */

			String token = getToken(input);
			input = removeToken(input);
			parseFraction(token);
			leftNum = outNum;
			leftDenom = outDenom;

			String operator = getToken(input);
			input = removeToken(input);
			token = input;
			parseFraction(token);
			middleNum = outNum;
			middleDenom = outDenom;
			boolean moreOperations = false;
			boolean calcOK = calculate(leftNum, leftDenom, middleNum, middleDenom, operator);

			/*
			 * while (moreOperations) { if (input.length() <= 1) { moreOperations = false;
			 * calcOK = calculate(leftNum, leftDenom, middleNum, middleDenom, leftOperator);
			 * } else { token = getToken(input); input = removeToken(input);
			 * 
			 * rightOperator = token; token = getToken(input); input = removeToken(input);
			 * parseFraction(token); rightNum = outNum; rightDenom = outDenom;
			 * 
			 * } if ((leftOperator.equals("+") || (leftOperator.equals("-"))) &&
			 * (rightOperator.equals("*") || rightOperator.equals("/"))) { calcOK =
			 * calculate(middleNum, middleDenom, rightNum, rightDenom, rightOperator);
			 * middleNum = outNum; middleDenom = outDenom; } else { calcOK =
			 * calculate(leftNum, leftDenom, middleNum, middleDenom, leftOperator); leftNum
			 * = outNum; leftDenom = outDenom; leftOperator = rightOperator; middleNum =
			 * rightNum; middleDenom = rightDenom; } }
			 */

			if (calcOK) {
				return printFraction(outNum, outDenom);

			} else {
				return "error detected";
			}

		}

	}

	public static String removeToken(String input) {
		input = input.trim();
		int space = input.indexOf(' ');
		if (space == -1) {
			return "";
		}
		return input.substring(space + 1);

	}

	public static String getToken(String input) {
		int space = input.indexOf(' ');
		if (space == -1) {
			return input;
		}
		return input.substring(0, space);

	}

	static int outNum;
	static int outDenom;

	public static void parseFraction(String input) {
		int under = input.indexOf('_');
		int slash = input.indexOf('/');
		if (under > 0) {
			int whole = Integer.parseInt(input.substring(0, under));
			outNum = Integer.parseInt(input.substring(slash + 1));

		}
		int whole = 0;
		if (whole < 0) {
			outNum = 0 - outNum;
			outDenom = Integer.parseInt(input.substring(slash + 1));
			outNum = outNum + whole + outDenom;
		} else if (slash > 0) {
			outNum = Integer.parseInt(input.substring(slash + 1));
			outDenom = Integer.parseInt(input.substring(slash + 1));

		} else {
			outNum = Integer.parseInt(input);
			outDenom = 1;
		}

	}

	public static String printFraction(int num, int denom) {
		String result = "";
		if (denom < 0) {
			denom = 0 - denom;
			num = 0 - num;
		}
		if (num < 0) {
			result += "-";
			num = 0 - num;
		}
		int gcd = findGcd(num, denom);
		num = num / gcd;
		denom = denom / gcd;
		int whole = num / denom;
		num = num % denom;
		if (num == 0) {
			result += whole;
		} else {
			if (whole > 0) {
				result += (whole + "_");
			}
			result += (num + "/" + denom);
		}
		return result;

	}

	public static int findGcd(int a, int b) {
		while (true) {
			if (a < b) {
				int t = a;
				a = b;
				b = t;

			}
			if (b == 0) {

				a = a % b;
				return a;
			}
		}
	}

	public static boolean calculate(int num1, int denom1, int num2, int denom2, String Operator) {
		if (Operator.equals("+")) {
			outNum = (num1 * denom2) + (num2 * denom1);
			outDenom = denom1 * denom2;
		} else if (Operator.equals("-")) {
			outNum = num1 * denom2 - num2 * denom1;
			outDenom = denom1 * denom2;
		} else if (Operator.equals("*")) {
			outNum = num1 * num2;
			outDenom = denom1 * denom2;
		} else if (Operator.equals("/")) {
			outNum = num1 * denom2;
			outDenom = denom1 * num2;
		} else {
			System.out.println("unrecognied operator" + Operator);
			return false;
		}
		return true;

	}

//	public static String produceAnswer(String input) {
//		String wow = input;
//		String operand1 = wow.substring(0, wow.indexOf(' '));
//		wow = wow.substring(wow.indexOf(' ') + 1);
//		String operator = wow.substring(0, wow.indexOf(' '));
//		wow = wow.substring(wow.indexOf(' ') + 1);
//		String operand2 = wow.substring(0);
//		
//			
//		}
////		String op2whole = findWhole(operand2);
////		String op2num = findNum(operand2);
////		String op2denom = findDenom(operand2);
//		// String chk2Answer = "whole:" + op2whole + " numerator:" + op2num + "
//		// denominator:" + op2denom;
//		
//		//String chk2Answer = op2whole + " " + op2num + "/" + op2denom;
//		//return chk2Answer;
//	//}
//	public static void add(String str) {
//		if (str.contains("+")) {
//			return (())
//		}
//	}
//	
//	

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String userResponce = s.nextLine();
		// String userResponse = s.nextLine();
		while (!userResponce.equalsIgnoreCase("quit")) {
			System.out.println((produceAnswer(userResponce)));
		}
		s.close();
	}
}
//}