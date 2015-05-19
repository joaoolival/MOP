package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

/**
 * for demo, continue demo
 * 
 * TODO Este código não está terminado, falta corrigir o aspecto dos números
 * negativos
 */
public class C14forDemo2 {

	/**
	 * main method - ler 10 inteiros positivos e calculara sua média
	 * */
	public static void main(String[] args) {
		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		int sum = 0;

		// read 10 positive integers
		for (int i = 0; i < 10; i++) {
			// read a positive > 0 number
			System.out.print("Introduza o número positivo nº " + (i + 1)
					+ " -> ");
			int number = keyboard.nextInt();
			if (number < 0) {
				System.out.println("O número " + number
						+ " não é um nº inteiro positivo!!");
				continue;
			}
			sum += number;
		}

		// show a count up
		System.out.print("A média dos números introduzidos é -> " + (sum / 10));

		// close the keyboard
		keyboard.close();
	}
}
