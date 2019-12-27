/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {
	public static void main(String[] args) {
//takes user input
		Scanner s = new Scanner(System.in);
		String input = "";
		String answer = "";
		
		input = s.nextLine();
		while (!input.equals("quit")) {
			answer = produceAnswer(input);
			System.out.println(answer);
			
			input = s.nextLine();
		}
		s.close();
	}

	public static String produceAnswer(String input) {
//numbers and operators 
		
		int wow = input.indexOf(' ');
		String operand1 = input.substring(0, wow);
		input = input.substring(wow + 1);
		char operator = input.charAt(0);
		int operand2 = input.indexOf(' ');
		input = input.substring(operand2 + 1);
		String second = input.substring(0);
//using symbols
		boolean underscore = false;
		boolean slash = false;
		for (int index = 0; index < operand1.length(); index++) {
			if (operand1.charAt(index) == '_') {
				underscore = true;
			} else if (operand1.charAt(index) == '/') {
				slash = true;
			}
		}
		//finding the first number
		int ina = operand1.indexOf('_');
		int inb = operand1.indexOf('/');
		int whole1;
		int num1;
		int denom1;
		//uses symbols
		if (underscore && slash) {
			whole1 = Integer.parseInt(operand1.substring(0, ina));
			num1 = Integer.parseInt(operand1.substring(ina + 1, inb));
			if (whole1 < 0) {
				num1 *= -1;
			}
			denom1 = Integer.parseInt(operand1.substring(inb + 1));
			num1 += whole1 * denom1;
		} else if (!underscore && slash) {
			num1 = Integer.parseInt(operand1.substring(0, inb));
			denom1 = Integer.parseInt(operand1.substring(inb + 1));
		} else {
			denom1 = 1;
			num1 = Integer.parseInt(operand1);
		}

		underscore = false;
		slash = false;
		for (int index = 0; index < second.length(); index++) {
			if (second.charAt(index) == '_') {
				underscore = true;
			} else if (second.charAt(index) == '/') {
				slash = true;
			}
		}
		//finding second number
		int whole2;
		int num2;
		int denom2;
		ina = second.indexOf('_');
		inb = second.indexOf('/');
		//uses symbols
		if (underscore && slash) {
			whole2 = Integer.parseInt(second.substring(0, ina));
			num2 = Integer.parseInt(second.substring(ina + 1, inb));
			if (whole2 < 0) {
				num2 *= -1;
			}
			denom2 = Integer.parseInt(second.substring(inb + 1));
			num2 += whole2 * denom2;
		} else if (!underscore && slash) {
			num2 = Integer.parseInt(second.substring(0, inb));
			denom2 = Integer.parseInt(second.substring(inb + 1));
		} else {
			num2 = Integer.parseInt(second);
			denom2 = 1;
		}

	
//uses the symbols to determine which operation to perform 
		int annum;
		int andenom = denom1 * denom2;
		if (operator == '+') {
			annum = num1 * denom2 + num2 * denom1;
		} else if (operator == '-') {
			annum = num1 * denom2 - num2 * denom1;
		} else if (operator == '*') {
			annum = num1 * num2;
		} else {
			annum = num1 * denom2;
			andenom = denom1 * num2;
		}
//fraction
		if (andenom == 1 || annum % andenom == 0) {
			return "" + (annum / andenom);
		}
		int mul = 1;
		if (annum < 0) {
			mul *= -1;
			annum *= -1;
		}
		if (andenom < 0) {
			mul *= -1;
			andenom *= -1;
		}
		//for reduction
		for (int i = 2; i <= Math.min(annum, andenom); i++) {
			while (annum % i == 0 && andenom % i == 0) {
				annum /= i;
				andenom /= i;
			}
		}
		if (annum < andenom) {
			return "" + (annum * mul) + '/' + andenom;
		}
		int whole = 0;
		while (annum > andenom) {
			annum -= andenom;
			whole += 1;
		}
		return "" + (whole * mul) + '_' + annum + '/' + andenom;
	}

}