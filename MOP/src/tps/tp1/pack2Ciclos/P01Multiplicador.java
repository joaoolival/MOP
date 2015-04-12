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
		 * Ciclo do-while: Pede ao utilizador que insira um número inteiro entre
		 * 0 e 20, e outro número inteiro entre 1 e 10, se os números inseridos
		 * não respeitarem alguma destas condições a variável invalido irá ficar
		 * a true e o ciclo não irá terminar, continuando a pedir os valores. Se
		 * o utilizador respeitar as condiçõe a variável invalido continuará a
		 * false terminando assim este ciclo for.
		 */
		do {
			invalido = false;
			System.out.println("Introduza um inteiro entre 0 e 20 -> ");
			num = keyboard.nextInt();

			System.out
					.println("Introduza o número de repetições entre 1 e 10 -> ");
			nReps = keyboard.nextInt();

			if ((num < 1 || num > 20) || (nReps < 1 || nReps > 10)) {
				System.out
						.println("Erro!! Valores inválidos! Por favor introduza os valores de novo.");
				invalido = true;
			}

		} while (invalido);

		/*
		 * resultado inicialmente irá ser igual ao 1º número inserido pelo
		 * utilizador
		 */
		resultado = num;
		// String multiplicação
		multiplicacao = "" + num;
		/*
		 * 2º Ciclo do-while: Atualiza as variáveis multiplicação, resultado e
		 * nReps até nReps ser igual a 1.
		 */
		do {
			nReps--;
			multiplicacao = multiplicacao + " x " + num;
			resultado *= num;
		} while (nReps != 1);

		// Mensagem que irá aparecer na consola.
		System.out.println("Resultado : " + multiplicacao + " = " + resultado);
		keyboard.close();

	}

}
