package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P01Ifs {

	public static void main(String[] args) {

		System.out.println("Insira um número maior que 10 ");
		// Inicialização da variável keyboard
		Scanner keyboard = new Scanner(System.in);

		/*
		 * definição da variável input como um boolean que irá tomaro valor true
		 * se a variável keyboard for um inteiro
		 */
		boolean input = keyboard.hasNextInt();

		/*
		 * Se o input for true, ou seja se o utilizador inseriu um inteiro na
		 * consola iremos guarda-lo na variável number. Em seguida, guardaremos
		 * o valor do resto da divisão por 7 na variável resto e o resultado da
		 * mesma divisão na variável quociente.
		 */
		if (input == true) {
			int number = keyboard.nextInt();
			float quociente = number / 7;
			float resto = number % 7;

			/*
			 * Se o número inserido pelo utilizador for maior que 10, mostra o
			 * resultado
			 */
			if (number > 10) {
				System.out.println("Resultados da divisão inteira de " + number
						+ " por 7 :");

				System.out.println("Número inserido : " + number);
				System.out.println("Divisor         : 7");
				System.out.println("Quociente       : " + quociente);
				System.out.println("Resto           : " + resto);
			}
			/*
			 * Se o número inserido for menor que 10 mostra uma mensagem de erro
			 * e informa o utilizador de que o programa irá terminado.
			 */
			else {
				System.out.println("Número inserido não é maior que 10. "
						+ "O programa vai terminar! ");
				System.exit(1);
			}
		}
		/*
		 * Caso o input não seja um inteiro, informa o utilizador de que foi
		 * inserido nenhum número e que o programa irá terminar.
		 */
		else {
			System.out.println("Não inseriu nenhum número. "
					+ "O programa vai terminar!");
			System.exit(1);
		}
		keyboard.close();
	}
}
