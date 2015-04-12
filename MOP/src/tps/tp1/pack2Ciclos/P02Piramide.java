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
		 * Ciclo do-while que está continuamente a pedir ao utilizador para
		 * introduzir um número inteiro ímpar entre 1 e 21 enquanto este não
		 * respeitar as condições.
		 */
		do {
			invalido = false;
			System.out.println("Introduza um número inteiro ímpar "
					+ "para o limite para a pirâmide entre 1 e 21 -> ");
			num = keyboard.nextInt();

			if ((num < 1 || num > 21) || (num % 2 != 1)) {
				System.out.println("Erro!! Valores inválidos! "
						+ "Por favor introduza os valores de novo.");
				invalido = true;
			}
		} while (invalido);

		/*
		 * Cálculo do número de espaços necessários da primeira linha para o
		 * número introduzido pelo utilizador
		 */
		int nEspacos = (num - 1) / 2;
		/*
		 * Cálculo do número total de linhas necessárias para o numero inserido
		 * pelo utilizador
		 */
		int nLinha = (num + 1) / 2;
		/*
		 * número de Cardinais necessários para a primeira linha
		 */
		int nCardinal = 1;

		/*
		 * for que percorre cada linha
		 */
		for (int linha = 0; linha < nLinha; linha++) {
			/*
			 * for que permite atualizar a string str com o número inicial de
			 * espaços necessários para cada linha
			 */
			for (int espaco = 0; espaco < nEspacos; espaco++) {
				str = str + " ";
			}
			/*
			 * for que permite atualizar a string card com o número de cardinais
			 * necessários para cada linha
			 */
			for (int cardinal = 0; cardinal < nCardinal; cardinal++) {
				card = card + "#";
			}
			// print da linha percorrida
			System.out.println(str + card);
			/*
			 * Atualização das variáveis para a próxima linha
			 */
			nEspacos--;
			nCardinal += 2;
			str = "";
			card = "";

		}
		keyboard.close();
	}
}
