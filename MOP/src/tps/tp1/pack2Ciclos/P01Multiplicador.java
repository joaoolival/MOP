package tps.tp1.pack2Ciclos;

import java.util.Scanner;

public class P01Multiplicador {

	public static void main(String[] args) {
		int num;
		int nReps;
		int resultado = 0;
		String multiplicacao = null;
		// boolean para possivel saida do ciclo do-while
		boolean invalido = false;

		// init scanner
		Scanner keyboard = new Scanner(System.in);

		/*
		 * Ciclo do-while: Pede ao utilizador que insira um n�mero inteiro entre
		 * 0 e 20, e outro n�mero inteiro entre 1 e 10, se os n�meros inseridos
		 * n�o respeitarem alguma destas condi��es a vari�vel invalido ir� ficar
		 * a true e o ciclo n�o ir� terminar, continuando a pedir os valores. Se
		 * o utilizador respeitar as condi��e a vari�vel invalido continuar� a
		 * false terminando assim este ciclo for.
		 */
		do {
			invalido = false;
			System.out.println("Introduza um inteiro entre 0 e 20 -> ");
			num = keyboard.nextInt();

			System.out
					.println("Introduza o n�mero de repeti��es entre 1 e 10 -> ");
			nReps = keyboard.nextInt();

			if ((num < 1 || num > 20) || (nReps < 1 || nReps > 10)) {
				System.out
						.println("Erro!! Valores inv�lidos! Por favor introduza os valores de novo.");
				invalido = true;
			}

		} while (invalido);

		/*
		 * resultado inicialmente ir� ser igual ao 1� n�mero inserido pelo
		 * utilizador
		 */
		resultado = num;
		// String multiplica��o
		multiplicacao = "" + num;
		/*
		 * 2� Ciclo do-while: Atualiza as vari�veis multiplica��o, resultado e
		 * nReps at� nReps ser igual a 1.
		 */
		do {
			nReps--;
			multiplicacao = multiplicacao + " x " + num;
			resultado *= num;
		} while (nReps != 1);

		// Mensagem que ir� aparecer na consola.
		System.out.println("Resultado : " + multiplicacao + " = " + resultado);
		keyboard.close();

	}

}
