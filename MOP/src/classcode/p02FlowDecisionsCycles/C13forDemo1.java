package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

/**
 * for demo
 */
public class C13forDemo1 {

	/**
	 * main method
	 */
	public static void main(String[] args) {
		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask the number of integers to read
		System.out
				.print("Introduza o n�mero de n�meros para calcular a m�dia -> ");
		int nNumbersToRead = keyboard.nextInt();

		// the total
		int total = 0;

		// check if we have something to do
		if (nNumbersToRead == 0) {
			System.out
					.println("N�o � poss�vel calcular a m�dia de 0 n�meros!!!");
		} else {

			// read the numbers
			for (int nNumbersRead = 0; nNumbersRead < nNumbersToRead; ++nNumbersRead) {

				// ask and read one number
				System.out.print("Introduza um inteiro -> ");
				int value = keyboard.nextInt();

				// add it to total
				total += value;
			}

			// show the average of them
			System.out.println("A m�dia dos n�meros � -> " + total
					/ nNumbersToRead);
		}

		// close the keyboard
		keyboard.close();
	}
}
