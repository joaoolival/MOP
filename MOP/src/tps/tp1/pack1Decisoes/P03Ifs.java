package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P03Ifs {

	public static void main(String[] args) {
		/*
		 * Este programa consiste em adivinhar uma letra entre A e F inclusivos
		 * que o utilizador tenha pensado. Para isso ir� fazer perguntas ao
		 * utilizador de forma a excluir hip�teses e adivinhar por fim a letra
		 * pensada.
		 */
		System.out.println("Pense numa letra de A a F (inclusivos).");
		System.out
				.println("  Responda �s quest�es com sim ou nao (sem acentos)");

		Scanner keyboard = new Scanner(System.in);

		System.out.println("O caracter pensado � maior ou igual que C?");

		if (keyboard.nextLine().equalsIgnoreCase("sim")) {
			System.out.println("O caracter pensado � menor que F?");
			if (keyboard.nextLine().equalsIgnoreCase("sim")) {
				System.out.println("O caracter pensado � menor que E?");
				if (keyboard.nextLine().equalsIgnoreCase("sim")) {
					System.out.println("O caracter pensado � menor que D?");
					if (keyboard.nextLine().equalsIgnoreCase("sim")) {
						System.out.println("O caracter pensado � C!");
					} else {
						System.out.println("O caracter pensado � D!");
					}
				} else {
					System.out.println("O caracter pensado � E!");
				}
			} else {
				System.out.println("O caracter pensado � F!");
			}
		}

		else {
			System.out.println("O caracter pensado � B?");
			if (keyboard.nextLine().equalsIgnoreCase("sim")) {
				System.out.println("O caracter pensado � B!");
			} else {
				System.out.println("O caracter pensado � A!");

			}

		}
		keyboard.close();
	}

}
