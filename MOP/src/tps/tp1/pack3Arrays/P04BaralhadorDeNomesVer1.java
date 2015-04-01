package tps.tp1.pack3Arrays;

import java.util.Scanner;

public class P04BaralhadorDeNomesVer1 {

	public static void main(String[] args) {
		Scanner keyboard = new java.util.Scanner(System.in);
		/* joao luis francisco jose antonio guilherme salvador ana carolina jose */

		System.out.println("Insert 10 complete names til 120 chars each -> ");
		System.out.println("Insert more than 5 names and write end to finish");

		String[][] myArray = new String[10][];
		String[] aux = new String[10];
		// tabela2[0] = new int[10];
		int arrayLength = 0;
		boolean testName = false;

		for (int i = 0; i < 10; i++) {
			//String name = keyboard.next();
			System.out.println("a");
			if (keyboard.hasNext()) {
				System.out.println("b\n");
				String name = keyboard.next();
				aux[i] = name;
				arrayLength = i;
				System.out.println(name);
			} else {
				testName = true;
				i = 10;
			}

			// condicao para testar se o nome e valido
			int nameLength = 0;
			int moreThan4 = 0;
			if (testName) {
				for (int j = 0; j < arrayLength; j++) {
					nameLength += aux[j].length();
					if (aux[j].length() >= 4) {
						moreThan4 += 1;
					}
				}
				if ((nameLength) > 120 || (moreThan4 < 3)) {
					System.out
							.println("This name is not Valid! Will be discarted");
					System.out.println("Insert again please");
					i = -1;
				}
				testName = false;
			}

		}

		System.out.println(arrayLength);

		myArray[0] = new String[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			myArray[0][i] = aux[i];
		}

		for (int i = 0; i < myArray[0].length; i++) {
			System.out.print(myArray[0][i] + " ");

		}

		keyboard.close();

	}

}
