package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

/**
 * Do-While demo
 */
public class C12DoWhile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// mensagem de t�tulo
		System.out.println("C�lculo da m�dia de n�meros inteiros positivos...");

		// vari�veis necess�rias

		// para controlar o ciclo de leitura
		boolean numeroNegativo = false;

		// para conter o n�mero de n�meros lidos
		int numerosLidos = 0;

		// para conter a soma dos n�meros lidos
		int total = 0;

		// ciclo de leitura
		do {
			// pedir e ler um n�mero
			System.out
					.print("Introduza um n�mero positivo (ou negativo para terminar) -> ");
			int numero = keyboard.nextInt();

			// se for negativo sinalizar que � para terminar o ciclo
			if (numero < 0)
				numeroNegativo = true;
			else {
				// se for positivo, incrementar o n�mero de n�meros lidos
				++numerosLidos;
				// adicion�-lo ao total
				total += numero;
			}
			// continuar com o ciclo se n�o tiver sido encontrado um n�mero
			// negativo
		} while (!numeroNegativo);

		// mostrar os resultados
		if (numerosLidos > 0) {
			System.out.println("Foram introduzidos " + numerosLidos
					+ " n�meros.");
			System.out.println("A sua m�dia � -> " + total / numerosLidos);
		} else
			System.out
					.println("N�o � poss�vel calcular a m�dia de 0 n�meros!!!");

		// close the keyboard
		keyboard.close();

	}
}
