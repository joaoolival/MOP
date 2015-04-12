package tps.tp1.pack2Ciclos;

import java.util.Scanner;

public class P02Piramide {

	public static void main(String[] args) {
		int num;
		String str = "";
		String card = "";
		// boolean para parar o ciclo do-while
		boolean invalido = false;
		// init scanner
		Scanner keyboard = new Scanner(System.in);
		/*
		 * Ciclo do-while que est� continuamente a pedir ao utilizador para
		 * introduzir um n�mero inteiro �mpar entre 1 e 21 enquanto este n�o
		 * respeitar as condi��es.
		 */
		do {
			invalido = false;
			System.out.println("Introduza um n�mero inteiro �mpar "
					+ "para o limite para a pir�mide entre 1 e 21 -> ");
			num = keyboard.nextInt();

			if ((num < 1 || num > 21) || (num % 2 != 1)) {
				System.out.println("Erro!! Valores inv�lidos! "
						+ "Por favor introduza os valores de novo.");
				invalido = true;
			}
		} while (invalido);

		/*
		 * C�lculo do n�mero de espa�os necess�rios da primeira linha para o
		 * n�mero introduzido pelo utilizador
		 */
		int nEspacos = (num - 1) / 2;
		/*
		 * C�lculo do n�mero total de linhas necess�rias para o numero inserido
		 * pelo utilizador
		 */
		int nLinha = (num + 1) / 2;
		/*
		 * n�mero de Cardinais necess�rios para a primeira linha
		 */
		int nCardinal = 1;

		/*
		 * for que percorre cada linha
		 */
		for (int linha = 0; linha < nLinha; linha++) {
			/*
			 * for que permite atualizar a string str com o n�mero inicial de
			 * espa�os necess�rios para cada linha
			 */
			for (int espaco = 0; espaco < nEspacos; espaco++) {
				str = str + " ";
			}
			/*
			 * for que permite atualizar a string card com o n�mero de cardinais
			 * necess�rios para cada linha
			 */
			for (int cardinal = 0; cardinal < nCardinal; cardinal++) {
				card = card + "#";
			}
			// print da linha percorrida
			System.out.println(str + card);
			/*
			 * Atualiza��o das vari�veis para a pr�xima linha
			 */
			nEspacos--;
			nCardinal += 2;
			str = "";
			card = "";

		}
		keyboard.close();
	}
}
