package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

/**
 * for demo, break demo
 */
public class C15forContinueDemo {

	/**
	 * main method
	 */
	public static void main(String[] args) {
		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		int number = 0;

		// to read a positive number bigger than zero
		do {
			// read a positive > 0 number
			System.out
					.print("Introduza o n�mero positivo e maior que zero -> ");
			number = keyboard.nextInt();
			if (number > 0)
				break;
			System.out.println("O n�mero " + number
					+ " n�o � um n� positivo e maior que zero!!");
			System.out.println();
		} while (true);

		// show a count up
		System.out.print("Contagem crescente de 0 at� " + number + " -> ");
		for (int i = 0; i <= number; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		// show a count down
		System.out.print("Contagem decrescente de " + number + " at� 0 -> ");
		for (int i = number; i >= 0; i--) {
			System.out.print(i + " ");
		}
		System.out.println();

		// show a different count up
		System.out
				.print("Contagem crescente de 100 em 100 a come�ar em 400 com "
						+ number + " n�meros -> ");
		for (int i = 0; i < number; i++) {
			System.out.print((i * 100 + 400) + " ");
		}
		System.out.println();

		// close the keyboard
		keyboard.close();
	}
}
