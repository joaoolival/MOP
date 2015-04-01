package tps.tp1.pack3Arrays;

import java.util.Random;

public class P05Xadrez {

	public static void main(String[] args) {
		// inicializacao de um array de 8 por 8
		int size = 6;
		char[][] xadrez = new char[size][size];
		// init random
		Random random = new Random();
		// atribuiçao das coordenadas aleatorias do bispo
		int xTorre1 = random.nextInt(size);
		int yTorre1 = random.nextInt(size);
		xadrez[xTorre1][yTorre1] = 'T';

		int xBispo1 = random.nextInt(size);
		int yBispo1 = random.nextInt(size);
		boolean bispo1 = false;

		while (!bispo1) {
			if ((yBispo1 == (yTorre1 + (xTorre1 - xBispo1)))
					|| (yBispo1 == (yTorre1 + (xBispo1 - xTorre1)))
					|| yBispo1 == yTorre1 || xBispo1 == xTorre1) {
				xBispo1 = random.nextInt(size);
				yBispo1 = random.nextInt(size);
			} else {
				xadrez[xBispo1][yBispo1] = 'B';
				bispo1 = true;
			}

		}

		int xBispo2 = random.nextInt(size);
		int yBispo2 = random.nextInt(size);
		boolean bispo2 = false;

		while (!bispo2) {
			if ((yBispo2 == (yTorre1 + (xTorre1 - xBispo2)))
					|| (yBispo2 == (yTorre1 + (xBispo2 - xTorre1)))
					|| (yBispo2 == yTorre1 || xBispo2 == xTorre1)
					|| (yBispo2 == (yBispo1 + (xBispo1 - xBispo2)))
					|| (yBispo2 == (yBispo1 + (xBispo2 - xBispo1)))) {
				xBispo2 = random.nextInt(size);
				yBispo2 = random.nextInt(size);
			} else {
				xadrez[xBispo2][yBispo2] = 'B';
				bispo2 = true;
			}
		}

		int xTorre2 = random.nextInt(size);
		int yTorre2 = random.nextInt(size);
		boolean torre2 = false;

		while (!torre2) {
			if ((yBispo2 == (yTorre2 + (xTorre2 - xBispo2)))
					|| (yBispo2 == (yTorre2 + (xBispo2 - xTorre2)))
					|| (yBispo2 == yTorre2 || xBispo2 == xTorre2)
					|| (yBispo1 == (yTorre2 + (xTorre2 - xBispo1)))
					|| (yBispo1 == (yTorre2 + (xBispo1 - xTorre2)))
					|| (yBispo1 == yTorre2 || xBispo1 == xTorre2)
					|| (yTorre2 == yTorre1 || xTorre2 == xTorre1)) {
				xTorre2 = random.nextInt(size);
				yTorre2 = random.nextInt(size);
			} else{
				xadrez[xTorre2][yTorre2] = 'T';
				torre2 = true;
			}
		}

		for (int xXadrez = 0; xXadrez < xadrez.length; xXadrez++) {
			for (int yXadrez = 0; yXadrez < xadrez[xXadrez].length; yXadrez++) {
				System.out.print("[" + xadrez[xXadrez][yXadrez] + "]");
			}
			System.out.println("");
		}

	}
}
