package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

/**
 * for demo, continue demo
 * 
 * TODO Este c�digo n�o est� terminado, falta corrigir o aspecto dos n�meros
 * negativos
 */
public class C14forDemo2 {

	/**
	 * main method - ler 10 inteiros positivos e calculara sua m�dia
	 * */
	public static void main(String[] args) {
		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		int sum = 0;

		// read 10 positive integers
		for (int i = 0; i < 10; i++) {
			// read a positive > 0 number
			System.out.print("Introduza o n�mero positivo n� " + (i + 1)
					+ " -> ");
			int number = keyboard.nextInt();
			if (number < 0) {
				System.out.println("O n�mero " + number
						+ " n�o � um n� inteiro positivo!!");
				continue;
			}
			sum += number;
		}

		// show a count up
		System.out.print("A m�dia dos n�meros introduzidos � -> " + (sum / 10));

		// close the keyboard
		keyboard.close();
	}
}
