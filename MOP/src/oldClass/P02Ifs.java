package oldClass;

import java.util.Scanner;

public class P02Ifs {

	public static void main(String[] args) {
		Scanner keyboard = new java.util.Scanner(System.in);

		System.out.println("Insert 3 different numbers -> ");

		int maior = keyboard.nextInt();
		int meio = keyboard.nextInt();
		int menor = keyboard.nextInt();
		int aux;

		if (maior < meio) {
			aux = maior;
			maior = meio;
			meio = aux;
		}

		if (maior < menor) {
			aux = maior;
			maior = menor;
			menor = aux;
		}

		if (meio < menor) {
			aux = meio;
			meio = menor;
			menor = aux;
		}

		if (maior == meio || maior == menor || meio == menor) {
			System.out.println("please, the numbers must be different");
		} else {
			System.out.println("the smallest number is " + menor
					+ " the middle number is " + meio
					+ " and the biggest number is " + maior);
			;
		}

		keyboard.close();
	}

}
