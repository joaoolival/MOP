package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P02Ifs {

	public static void main(String[] args) {

		System.out.println("Insira 3 n�meros inteiros:");

		Scanner keyboard = new Scanner(System.in);
		/*
		 * vari�vel boolean input que ir� verificar se foi inserido n�meros
		 * inteiros
		 */
		boolean input = keyboard.hasNextInt();

		/*
		 * inicializa��o das vari�veis maior, meio e menor que iram tomar os
		 * valores dos tr�s n�meros inteiros introduzidos pelo utilizador. A
		 * vari�vel maior ir� tomar o valor do primeiro n�mero inserido, a meio
		 * ir� tomar o valor do segundo n�mero e finalmente a menor ir� ficar
		 * com o �ltimo valor inteiro inserido na consola. Inicializa��o da
		 * vari�vel aux.
		 */
		int maior = keyboard.nextInt();
		int meio = keyboard.nextInt();
		int menor = keyboard.nextInt();
		int aux;

		/*
		 * Se houver input, ou seja, se este for true, ir� avaliar analisar qual
		 * dos 3 n�meros inseridos tem o valor maior, qual tem o menor valor e
		 * qual tem o valor do meio.
		 */
		if (input == true) {

			/*
			 * Se o valor da vari�vel maior for menor que o da vari�vel meio
			 * ent�o teremos que atualizar as vari�veis trocando os valores para
			 * as vari�veis corretas, ou seja, o valor da vari�vel maior vai
			 * ficar na vari�vel meio e o valor da vari�vel meio vai ficar na
			 * vari�vel maior. Para tal iremos utilizar uma vari�vel auxiliar,
			 * aux, que ir� guardar o valor da vari�vel maior, enquanto que esta
			 * toma o valor da vari�vel meio.
			 */
			if (maior < meio) {
				aux = maior;
				maior = meio;
				meio = aux;
			}

			/*
			 * Se o valor da vari�vel maior for menor que o da vari�vel menor
			 * ent�o teremos que atualizar as vari�veis trocando os valores para
			 * as vari�veis corretas, ou seja, o valor da vari�vel maior vai
			 * ficar na vari�vel menor e o valor da vari�vel menor vai ficar na
			 * vari�vel maior. Para tal iremos utilizar uma vari�vel auxiliar,
			 * aux, que ir� guardar o valor da vari�vel maior, enquanto que esta
			 * toma o valor da vari�vel menor.
			 */
			if (maior < menor) {
				aux = maior;
				maior = menor;
				menor = aux;
			}

			/*
			 * Se o valor da vari�vel meio for menor que o da vari�vel menor
			 * ent�o teremos que atualizar as vari�veis trocando os valores para
			 * as vari�veis corretas, ou seja, o valor da vari�vel meio vai
			 * ficar na vari�vel menor e o valor da vari�vel menor vai ficar na
			 * vari�vel meio. Para tal iremos utilizar uma vari�vel auxiliar,
			 * aux, que ir� guardar o valor da vari�vel meio, enquanto que esta
			 * toma o valor da vari�vel menor.
			 */
			if (meio < menor) {
				aux = meio;
				meio = menor;
				menor = aux;
			}
			/*
			 * Se os tr�s n�meros forem iguais ir� aparecer na consola essa
			 * informa��o.
			 */
			if (maior == meio && maior == menor && meio == menor) {
				System.out.println("Os n�meros s�o iguais");
			}
			/*
			 * Caso sejam diferentes ir� aparecer na consola qual o n�mero
			 * maior, qual o do meio, e qual o menor.
			 */
			else {
				System.out.println("O  menor valor � " + menor
						+ ", o valor do meio � " + meio + " e o maior valor � "
						+ maior);
			}
		}
		keyboard.close();
	}
}
