package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

/**
 * While demo
 */
public class C11While {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask the number of integers to read
		System.out
				.print("Introduza o n�mero de n�meros para calcular a m�dia -> ");
		int nNumbersToRead = keyboard.nextInt();

		int nNumbersRead = 0;
		int total = 0;

		// read the numbers
		while (nNumbersRead < nNumbersToRead) {
			// ask and read one number
			System.out.print("Introduza um inteiro -> ");
			int value = keyboard.nextInt();
			// count with it
			++nNumbersRead;
			// add it to total
			total += value;
		}

		// check to see if it is possible to show the average
		if (nNumbersToRead == 0)
			System.out
					.println("N�o � poss�vel calcular a m�dia de 0 n�meros!!!");
		else
			System.out.println("A m�dia dos n�meros � -> " + total
					/ nNumbersToRead);

		// close the keyboard
		keyboard.close();

	}
}
