/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static String produceAnswer(String input) {
		//Scanner s = new Scanner(input);
		// String firstOperand = s.next();

		// String operator = s.next();
		// String secondOperand = s.next();

		// return secondOperand;
		String wow = input;
		String operand1 = wow.substring(0, wow.indexOf(' '));
		wow = wow.substring(wow.indexOf(' ') + 1);
		String operator = wow.substring(0, wow.indexOf(' '));
		wow = wow.substring(wow.indexOf(' ') + 1);
		String operand2 = wow.substring(0);

		String op2whole = findWhole(operand2);
		String op2num = findNum(operand2);
		String op2denom = findDenom(operand2);

		String chk2Answer = "whole:" + op2whole + " numerator:" + op2num + " denominator:" + op2denom;

		return chk2Answer;

	}

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

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String userResponce = s.nextLine();
		String userResponse = s.nextLine();
		while (!userResponse.equalsIgnoreCase("quit")) {
			System.out.println((produceAnswer(userResponce)));

		}
	}

}
