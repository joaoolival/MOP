package oldClass.tp1;

import java.util.Scanner;

public class P02ArrayIntsAddMirror {

	public static void main(String[] args) {
		Scanner keyboard = new java.util.Scanner(System.in);
		int[] myArray = new int[10];
		int aux = myArray.length - 1;
		int auxValue = 0;

		System.out.println("Please insert 10 integer number between 10 and 99");
		// ciclo para certificar os 10 valores do array
		for (int i = 0; i < myArray.length; i++) {
			int keyboardValue = keyboard.nextInt();
			// condicao que certifica os valores
			if (keyboardValue >= 10 && keyboardValue <= 99) {
				myArray[i] = keyboardValue;
				// reiniciar for em caso de erro de valor
			} else {
				i = -1;
				System.out
						.println("Error! Please insert again all the Values between 10 and 99");
			}
		}
		// ciclo para ser impresso o array separado por virgulas
		for (int i = 0; i < myArray.length; i++) {
			// condicao para imprimir o novo array separado por virgulas
			if (i < myArray.length - 1) {
				System.out.print(myArray[i] + ", ");

			} else {

				System.out.println(myArray[i]);
			}

		}
		// ciclo que soma as duas partes do array
		for (int i = 0; i < myArray.length / 2; i++) {

			// valor auxilar para somar a segunda parte do array
			auxValue = myArray[i];

			// actualizacao dos 5 primeiros valores
			myArray[i] += myArray[aux];

			// actualizacao dos 5 ultimos valores
			myArray[aux] += auxValue;

			// renovacao do auxiliar para posicao
			aux--;
		}

		for (int i = 0; i < myArray.length; i++) {
			// condicao para imprimir o novo array separado por virgulas
			if (i < myArray.length - 1) {
				System.out.print(myArray[i] + ", ");

			} else {

				System.out.print(myArray[i]);
			}

		}

		keyboard.close();
	}

}
