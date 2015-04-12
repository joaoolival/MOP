package oldClass.tp1;

import java.util.Scanner;

public class P01Multiplicador {

	public static void main(String[] args) {
		// init scanner
		Scanner keyboard = new java.util.Scanner(System.in);
		// boolean para possivel saida do ciclo
		boolean go = true;
		int nReps = 0;
		int num = 0;

		// ciclo while para repeticao do pedido caso nao se insiram os valores
		// pretendidos
		while (go) {

			System.out
					.println("choose a number to reply, between 1 and 20 -> ");
			// valor guardado para repetir
			num = keyboard.nextInt();

			System.out
					.println("choose the number of replys, between 1 and 10 -> ");
			// valor guardado de repeticoes
			nReps = keyboard.nextInt();
			// condicao para a pergunta ser repetida
			if ((num < 1 || num > 20) || (nReps < 1 || nReps > 10)) {
				System.out.println("error, please respect the awnser");
				// condicao caso ja existam 2 valores pretendidos
			} else {
				go = false;

			}
		}

		int i = 0;
		int result = 1;
		while (nReps > i) {
			// contador para saida do while
			i++;
			// actualizacao do resultado
			// multiplicacao sucessiva do valor escolhido o numero pretendido
			result = result * num;
		}
		System.out.println(result);

		keyboard.close();
	}

}
