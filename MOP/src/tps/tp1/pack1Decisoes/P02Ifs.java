package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P02Ifs {

	public static void main(String[] args) {

		System.out.println("Insira 3 números inteiros:");

		Scanner keyboard = new Scanner(System.in);
		/*
		 * variável boolean input que irá verificar se foi inserido números
		 * inteiros
		 */
		boolean input = keyboard.hasNextInt();

		/*
		 * inicialização das variáveis maior, meio e menor que iram tomar os
		 * valores dos três números inteiros introduzidos pelo utilizador. A
		 * variável maior irá tomar o valor do primeiro número inserido, a meio
		 * irá tomar o valor do segundo número e finalmente a menor irá ficar
		 * com o último valor inteiro inserido na consola. Inicialização da
		 * variável aux.
		 */
		int maior = keyboard.nextInt();
		int meio = keyboard.nextInt();
		int menor = keyboard.nextInt();
		int aux;

		/*
		 * Se houver input, ou seja, se este for true, irá avaliar analisar qual
		 * dos 3 números inseridos tem o valor maior, qual tem o menor valor e
		 * qual tem o valor do meio.
		 */
		if (input == true) {

			/*
			 * Se o valor da variável maior for menor que o da variável meio
			 * então teremos que atualizar as variáveis trocando os valores para
			 * as variáveis corretas, ou seja, o valor da variável maior vai
			 * ficar na variável meio e o valor da variável meio vai ficar na
			 * variável maior. Para tal iremos utilizar uma variável auxiliar,
			 * aux, que irá guardar o valor da variável maior, enquanto que esta
			 * toma o valor da variável meio.
			 */
			if (maior < meio) {
				aux = maior;
				maior = meio;
				meio = aux;
			}

			/*
			 * Se o valor da variável maior for menor que o da variável menor
			 * então teremos que atualizar as variáveis trocando os valores para
			 * as variáveis corretas, ou seja, o valor da variável maior vai
			 * ficar na variável menor e o valor da variável menor vai ficar na
			 * variável maior. Para tal iremos utilizar uma variável auxiliar,
			 * aux, que irá guardar o valor da variável maior, enquanto que esta
			 * toma o valor da variável menor.
			 */
			if (maior < menor) {
				aux = maior;
				maior = menor;
				menor = aux;
			}

			/*
			 * Se o valor da variável meio for menor que o da variável menor
			 * então teremos que atualizar as variáveis trocando os valores para
			 * as variáveis corretas, ou seja, o valor da variável meio vai
			 * ficar na variável menor e o valor da variável menor vai ficar na
			 * variável meio. Para tal iremos utilizar uma variável auxiliar,
			 * aux, que irá guardar o valor da variável meio, enquanto que esta
			 * toma o valor da variável menor.
			 */
			if (meio < menor) {
				aux = meio;
				meio = menor;
				menor = aux;
			}
			/*
			 * Se os três números forem iguais irá aparecer na consola essa
			 * informação.
			 */
			if (maior == meio && maior == menor && meio == menor) {
				System.out.println("Os números são iguais");
			}
			/*
			 * Caso sejam diferentes irá aparecer na consola qual o número
			 * maior, qual o do meio, e qual o menor.
			 */
			else {
				System.out.println("O  menor valor é " + menor
						+ ", o valor do meio é " + meio + " e o maior valor é "
						+ maior);
			}
		}
		keyboard.close();
	}
}
