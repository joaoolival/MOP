package tps.tp1.pack3Arrays;

import java.util.Random;
import java.util.Scanner;

public class P04BaralhadorDeNomes {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner keyboard = new java.util.Scanner(System.in);

		/* joao luis francisco jose antonio guilherme salvador ana carolina jose */

		System.out.println("Insert 10 complete names til 120 chars each -> ");
		System.out.println("Insert more than 5 names and write end to finish");

		String[] auxArray = new String[10];

		int nameLenght;
		int moreThan;
		String subName;
		int i = 0;
		for (i = 0; i < auxArray.length; i++) {
			nameLenght = 0;
			moreThan = 0;

			String name = keyboard.nextLine();
			name.trim();
			if (name.equals("fim")) {
				if (i >= 5) {
					break;
				} else {
					System.out.println("por favor insira pelo menos 5 nomes");
				}
			}
			// analise para ver se o nome irá ser aceite
			Scanner scanString = new java.util.Scanner(name);
			while (scanString.hasNext()) {
				subName = scanString.next();
				if ((subName.length()) >= 4)
					moreThan += 1;
				nameLenght += subName.length();
			}

			if ((nameLenght <= 120) && (moreThan >= 3)) {
				auxArray[i] = name;
			} else {
				System.out.println("Nome não aceite");
				System.out.println("Por favor introduza novamente");
				i -= 1;
			}

			scanString.close();
		}
		keyboard.close();

		String[] myArray = new String[i];
		for (int j = 0; j < i; j++) {
			myArray[j] = auxArray[j];
		}

		System.out.println("");
		System.out.println("The accepted names are ->");
		for (i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i]);
		}

		String[] firstName = new String[myArray.length];
		String[] lastName = new String[myArray.length];
		String[] middleName = new String[myArray.length];

		for (i = 0; i < myArray.length; i++) {
			int auxArrayLenght = 1;
			for (int j = 0; j < myArray[i].length(); j++) {
				if (myArray[i].charAt(j) == ' ') {
					auxArrayLenght += 1;
				}
			}

			auxArray = new String[auxArrayLenght];
			Scanner scanString = new java.util.Scanner(myArray[i]);
			for (int j = 0; j < auxArrayLenght; j++) {
				auxArray[j] = scanString.next();
			}

			firstName[i] = auxArray[0];
			lastName[i] = auxArray[(auxArray.length) - 1];
			
			

			int randomQ = random.nextInt((auxArray.length) - 2) + 1;
			while (auxArray[randomQ].length() < 3) {
				randomQ = random.nextInt((auxArray.length) - 2) + 1;
			}
			middleName[i] = auxArray[randomQ];

			scanString.close();

		}
		System.out.println(firstName.length);
		System.out.println(middleName.length);
		System.out.println(lastName.length);
		

		String[][] newNames = new String[myArray.length][3];

		for (int j = 0; j < myArray.length; j++) {
			newNames[j][0] = firstName[random.nextInt(firstName.length - 1)];
			newNames[j][1] = middleName[random.nextInt(middleName.length - 1)];
			newNames[j][2] = lastName[random.nextInt(lastName.length - 1)];
		}
		System.out.println("");
		System.out.println("");
		System.out.println("new names ->");

		for (int j = 0; j < newNames.length; j++) {
			for (int j2 = 0; j2 < 3; j2++) {
				System.out.print(newNames[j][j2] + " ");
			}
			System.out.println(" ");
		}
		
		for (int j = 0; j < middleName.length; j++) {
			System.out.println(middleName[j] + " ");
		}

	}
}
