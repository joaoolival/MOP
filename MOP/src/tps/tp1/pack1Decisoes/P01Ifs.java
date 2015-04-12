package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P01Ifs {

	public static void main(String[] args) {

		System.out.println("Insira um n�mero maior que 10 ");
		// Inicializa��o da vari�vel keyboard
		Scanner keyboard = new Scanner(System.in);

		/*
		 * defini��o da vari�vel input como um boolean que ir� tomaro valor true
		 * se a vari�vel keyboard for um inteiro
		 */
		boolean input = keyboard.hasNextInt();

		/*
		 * Se o input for true, ou seja se o utilizador inseriu um inteiro na
		 * consola iremos guarda-lo na vari�vel number. Em seguida, guardaremos
		 * o valor do resto da divis�o por 7 na vari�vel resto e o resultado da
		 * mesma divis�o na vari�vel quociente.
		 */
		if (input == true) {
			int number = keyboard.nextInt();
			float quociente = number / 7;
			float resto = number % 7;

			/*
			 * Se o n�mero inserido pelo utilizador for maior que 10, mostra o
			 * resultado
			 */
			if (number > 10) {
				System.out.println("Resultados da divis�o inteira de " + number
						+ " por 7 :");

				System.out.println("N�mero inserido : " + number);
				System.out.println("Divisor         : 7");
				System.out.println("Quociente       : " + quociente);
				System.out.println("Resto           : " + resto);
			}
			/*
			 * Se o n�mero inserido for menor que 10 mostra uma mensagem de erro
			 * e informa o utilizador de que o programa ir� terminado.
			 */
			else {
				System.out.println("N�mero inserido n�o � maior que 10. "
						+ "O programa vai terminar! ");
				System.exit(1);
			}
		}
		/*
		 * Caso o input n�o seja um inteiro, informa o utilizador de que foi
		 * inserido nenhum n�mero e que o programa ir� terminar.
		 */
		else {
			System.out.println("N�o inseriu nenhum n�mero. "
					+ "O programa vai terminar!");
			System.exit(1);
		}
		keyboard.close();
	}
}
