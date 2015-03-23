package tps.tp1.pack2Ciclos;

import java.util.Scanner;

public class P02Piramide {

	public static void main(String[] args) {
		// init scanner
		Scanner keyboard = new java.util.Scanner(System.in);

		// boolean para while
		boolean go = true;
		int val = 0;

		// while para certificar que é impar
		while (go) {
			System.out.println("Insert an odd number between 1 and 21 -> ");

			val = keyboard.nextInt();
			// condicao para sair do while
			if (val % 2 != 0 && (val >= 1 && val <= 21)) {
				go = false;
			} else {
				System.out.println("please respect the awnser");
			}
		}
		int initialCardinal = 1;
		int initialSpaces = val / 2;
		int numLines = val - initialSpaces;
		// for que percorre o numero de linhas necessarias
		for (int i = 0; i < numLines; i++) {
			// for que percorre o numero de vezes para colocar espaco em cada
			// linha
			for (int j = 0; j < initialSpaces; j++) {
				System.out.print(" ");
			}
			// for que coloca cardinais
			for (int k = 1; k < initialCardinal; k++) {
				System.out.print("#");
			}
			// ultimo cardinal com println
			System.out.println("#");

			// actualizacao do valor necessario de espacos e cardinais
			initialSpaces--;
			initialCardinal+=2;
		}

		keyboard.close();

	}

}
