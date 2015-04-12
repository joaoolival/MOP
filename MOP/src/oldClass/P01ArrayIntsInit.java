package oldClass;

public class P01ArrayIntsInit {

	public static void main(String[] args) {
		// init array
		int[] myArray = { 2, 70, 54, 9, 7, 57, 55, 77, 88, 5 };
		int menorImpar = 0;
		boolean choose = true;

		System.out.print("[");
		// ciclo for para escolher menor impar
		for (int j = 0; j < myArray.length; j++) {

			// condicao para escolher o primeiro valor impar
			if (myArray[j] % 2 != 0 && choose) {
				menorImpar = myArray[j];
				choose = false;
			}

			// condicao para verificar se o valor impar encontrado e menor que o
			// ultimo guardado na variavel menorImpar
			if ((myArray[j] < menorImpar) && myArray[j] % 2 != 0) {
				menorImpar = myArray[j];
			}

			// condicao para imprimir array iniciar correctamente separado por
			// virgulas
			if (j < myArray.length - 1) {
				System.out.print(myArray[j] + ", ");

			} else {

				System.out.print(myArray[j]);
			}
		}
		System.out.println("]");
		System.out.println("The lowest odd value is -> " + menorImpar);

		System.out.print("[");
		// ciclo para incrementar o menor valor impar aos restantes valores
		// impares
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] % 2 != 0) {
				myArray[i] += menorImpar;
			}
			// condicao para imprimir o novo array separado por virgulas
			if (i < myArray.length - 1) {
				System.out.print(myArray[i] + ", ");

			} else {

				System.out.print(myArray[i]);
			}

		}
		System.out.print("]");

	}

}
