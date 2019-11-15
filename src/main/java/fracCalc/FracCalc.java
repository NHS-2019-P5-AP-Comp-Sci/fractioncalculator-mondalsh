/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static String produceAnswer(String input) {
		Scanner s = new Scanner(input);
		String firstOperand = s.next();
		
		String operator = s.next();
		String secondOperand = s.next();

		return secondOperand;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String userResponce = s.nextLine();
		
		System.out.println((produceAnswer(userResponce)));
	}
}
