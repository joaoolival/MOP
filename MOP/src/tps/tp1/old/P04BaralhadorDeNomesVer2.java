package tps.tp1.old;

import java.util.Random;
import java.util.Scanner;

public class P04BaralhadorDeNomesVer2 {

	public static void main(String[] args) {
		// init random
		Random random = new Random();
		// init scanner
		Scanner keyboard = new java.util.Scanner(System.in);

		/* joao luis francisco jose antonio guilherme salvador ana carolina jose */

		System.out.println("Insert 10 complete names til 120 chars each -> ");
		System.out.println("Insert more than 5 names and write end to finish");

		// string auxiliar com o numero maximo de nomes
		String[] auxArray = new String[10];
		// variaveis auxiliares
		int nameLenght;
		int moreThan;
		String subName;
		int i = 0;
		// ciclo for para colocar os nomes dentro do array de strings
		for (i = 0; i < auxArray.length; i++) {
			nameLenght = 0;
			moreThan = 0;
			// variavel onde os nomes sao guardados
			String name = keyboard.nextLine();
			// trim para anular os espaços laterais entre os nomes
			name.trim();
			// condicao para testar se o utilizador pretende acabar a introducao
			// de nomes
			if (name.equals("fim")) {
				if (i >= 5) {
					break;
				} else {
					System.out.println("por favor insira pelo menos 5 nomes");
				}
			}
			// analise para ver se o nome irá ser aceite
			// init de um scanner so para uma string de nome
			Scanner scanString = new java.util.Scanner(name);
			// ciclo para percorrer todas as palavras da string nome
			while (scanString.hasNext()) {
				subName = scanString.next();
				// condicao que testa quantos nomes tem 4 ou mais letras
				if ((subName.length()) >= 4)
					moreThan += 1;
				// variavel que guarda a quantidade de caracteres que um nome
				// tem
				nameLenght += subName.length();
			}
			// condicao para averiguar se o nome poderá ser aceite
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
		// novo array de nomes com o comprimento correcto
		String[] myArray = new String[i];
		for (int j = 0; j < i; j++) {
			myArray[j] = auxArray[j];
		}

		// print dos nomes que foram aceites
		System.out.println("");
		System.out.println("The accepted names are ->");
		for (i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i]);
		}
		// init de arrays que vao comportar os varios nomes pedidos
		String[] firstName = new String[myArray.length];
		String[] lastName = new String[myArray.length];
		String[] middleName = new String[myArray.length];

		// ciclo que percorre as strings nome e guarda o numero de espaços entre
		// os varios subnomes de cada nome
		for (i = 0; i < myArray.length; i++) {
			int auxArrayLenght = 1;
			for (int j = 0; j < myArray[i].length(); j++) {
				if (myArray[i].charAt(j) == ' ') {
					auxArrayLenght += 1;
				}
			}
			//init de um array com o numero de subnomes que cada nome tem
			auxArray = new String[auxArrayLenght];
			//init de um novo scanner para ler cada string
			Scanner scanString = new java.util.Scanner(myArray[i]);
			//ciclo que guarda cada subnome num array
			for (int j = 0; j < auxArrayLenght; j++) {
				auxArray[j] = scanString.next();
			}
			//cada primeiro nome e guardado aqui
			firstName[i] = auxArray[0];
			//cada ultimo nome e guardado aqui
			lastName[i] = auxArray[(auxArray.length) - 1];
			
			int randomQ = random.nextInt((auxArray.length) - 2) + 1;
			while (auxArray[randomQ].length() < 3) {
				randomQ = random.nextInt((auxArray.length) - 2) + 1;
			}
			//cada nome do meio random e guardado aqui
			//um de cada nome
			middleName[i] = auxArray[randomQ];

			scanString.close();

		}
		//init de um novo array para os novos nomes gerados
		//cada linha do array bidimensional comportará um nome gerado
		String[][] newNames = new String[myArray.length][3];
		//ciclo onde sao postos os varios nomes de forma random
		for (int j = 0; j < myArray.length; j++) {
			newNames[j][0] = firstName[random.nextInt(firstName.length - 1)];
			newNames[j][1] = middleName[random.nextInt(middleName.length - 1)];
			newNames[j][2] = lastName[random.nextInt(lastName.length - 1)];
		}
		System.out.println("");
		System.out.println("");
		System.out.println("new names ->");
		//ciclo onde sao apresentados os novos nomes
		for (int j = 0; j < newNames.length; j++) {
			for (int j2 = 0; j2 < 3; j2++) {
				System.out.print(newNames[j][j2] + " ");
			}
			System.out.println(" ");
		}


	}
}
