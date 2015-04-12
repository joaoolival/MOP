package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P03Ifs {

	public static void main(String[] args) {
		/*
		 * Este programa consiste em adivinhar uma letra entre A e F inclusivos
		 * que o utilizador tenha pensado. Para isso irá fazer perguntas ao
		 * utilizador de forma a excluir hipóteses e adivinhar por fim a letra
		 * pensada.
		 */
		System.out.println("Pense numa letra de A a F (inclusivos).");
		System.out
				.println("  Responda às questões com sim ou nao (sem acentos)");

		Scanner keyboard = new Scanner(System.in);

		System.out.println("O caracter pensado é maior ou igual que C?");

		if (keyboard.nextLine().equalsIgnoreCase("sim")) {
			System.out.println("O caracter pensado é menor que F?");
			if (keyboard.nextLine().equalsIgnoreCase("sim")) {
				System.out.println("O caracter pensado é menor que E?");
				if (keyboard.nextLine().equalsIgnoreCase("sim")) {
					System.out.println("O caracter pensado é menor que D?");
					if (keyboard.nextLine().equalsIgnoreCase("sim")) {
						System.out.println("O caracter pensado é C!");
					} else {
						System.out.println("O caracter pensado é D!");
					}
				} else {
					System.out.println("O caracter pensado é E!");
				}
			} else {
				System.out.println("O caracter pensado é F!");
			}
		}

		else {
			System.out.println("O caracter pensado é B?");
			if (keyboard.nextLine().equalsIgnoreCase("sim")) {
				System.out.println("O caracter pensado é B!");
			} else {
				System.out.println("O caracter pensado é A!");

			}

		}
		keyboard.close();
	}

}
