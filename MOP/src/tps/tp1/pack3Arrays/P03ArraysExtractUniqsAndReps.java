package tps.tp1.pack3Arrays;

import java.util.Random;

public class P03ArraysExtractUniqsAndReps {

	/*
	 * Fa�a o programa P03ArraysExtractUniqsAndReps que: declare dois arrays de
	 * 10 inteiros, iniciados com recurso ao gerador aleat�rio Random, com
	 * valores compreendidos entre 0 e 20 (os dois inclusive) mas que n�o tenham
	 * repeti��es dentro do mesmo array (repetindo a gera��o aleat�ria se
	 * necess�rio); mostre o conte�do dos dois arrays na consola; obtenha num
	 * array somente os valores que n�o t�m repeti��es entre os dois array
	 * iniciais; obtenha num outro array somente os valores que t�m repeti��es
	 * entre os dois array iniciais; os dois array finais devem ter a dimens�o
	 * exacta para conterem os devidos elementos; e mostre o conte�do dos dois
	 * arrays finais na consola. Exemplo da utiliza��o do gerador aleat�rio:
	 * �Random.nextInt(10)� devolve um valor aleat�rio no intervalo [0..9].
	 * Exemplo do pretendido: a1 = [2, 6, 8, 4, 9], a2 = [5, 6, 2, 7, 8], array
	 * de �nicos = [4, 9, 5, 7], array de repetidos = [2, 6, 8]. A ordem dos
	 * elementos nos arrays finais n�o � relevante.
	 */

	public static void main(String[] args) {
		Random random = new Random();
		int[] a1 = new int[5];
		boolean a1Boolean = true;
		boolean a2Boolean = true;
		int[] a2 = new int[5];
		//int[] uniqArray = new int[5];
		int[] repArray = new int[5];
		
		for (int i = 0; i < a1.length; i++) {
			a1[i] = random.nextInt(5);
			for (int j = 0; j < i; j++) {
				if (a1[i] == a1[j]) {
					a1[i] = random.nextInt(5);
					j = -1;
				}
			}
		}
		
		for (int i = 0; i < a2.length; i++) {
			a1[i] = random.nextInt(5);
			for (int j = 0; j < i; j++) {
				if (a2[i] == a2[j]) {
					a2[i] = random.nextInt(5);
					j = -1;
				}
			}
		}
		
		System.out.print("a1 -> ");
		for (int i = 0; i < a1.length; i++) {
			// condicao para imprimir o novo array separado por virgulas
			if (i < a1.length - 1) {
				System.out.print(a1[i] + ", ");

			} else {

				System.out.println(a1[i]);
			}

		}
		System.out.println("");
		System.out.println("");
		System.out.print("a2 -> ");
		for (int i = 0; i < a2.length; i++) {
			// condicao para imprimir o novo array separado por virgulas
			if (i < a2.length - 1) {
				System.out.print(a2[i] + ", ");

			} else {

				System.out.println(a2[i]);
			}

		}

		int rep = 0;
		//int uniq = 0;
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				if (a1[i] == a2[j]) {
					repArray[rep] = a1[i];
					rep++;
				}
			}

		}
		System.out.println("");
		System.out.println("");
		System.out.print("rep -> ");
		for (int i = 0; i < repArray.length; i++) {
			// condicao para imprimir o novo array separado por virgulas
			if (i < repArray.length - 1) {
				System.out.print(repArray[i] + ", ");

			} else {

				System.out.print(repArray[i]);
			}

		}

	}

}
