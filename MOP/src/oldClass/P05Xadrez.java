package oldClass;

import java.util.Random;
import java.util.Scanner;

public class P05Xadrez {

	public static void main(String[] args) {
		// init scanner
		Scanner keyboard = new java.util.Scanner(System.in);
		//ciclo para repetir tabuleiro
		while (true) {
			//tamanho do tabuleiro
			int size = 8;
			// inicializacao de um array de 8 por 8
			char[][] xadrez = new char[size][size];
			// init random
			Random random = new Random();
			// atribuiçao das coordenadas aleatorias da Torre1
			int xTorre1 = random.nextInt(size);
			int yTorre1 = random.nextInt(size);
			xadrez[xTorre1][yTorre1] = 'T';
			// init numero de ataques
			int totalAttacks = 0;
			// atribuiçao das coordenadas aleatorias do Bispo1
			int xBispo1 = random.nextInt(size);
			int yBispo1 = random.nextInt(size);
			boolean bispo1 = false;
			// ciclo para verificar se o bispo nao esta a ser atacado pela
			// torre
			while (!bispo1) {
				// caso esteja a ser atacado
				if ((yBispo1 == (yTorre1 + (xTorre1 - xBispo1)))
						|| (yBispo1 == (yTorre1 + (xBispo1 - xTorre1)))
						|| yBispo1 == yTorre1 || xBispo1 == xTorre1) {
					// novas coordenadas random seram avaliadas
					xBispo1 = random.nextInt(size);
					yBispo1 = random.nextInt(size);
				} else {
					// caso nao esteja a ser atacado o programa prossegue
					xadrez[xBispo1][yBispo1] = 'B';
					bispo1 = true;
				}

			}
			// coordenadas aleatorias para o Bispo2
			int xBispo2 = random.nextInt(size);
			int yBispo2 = random.nextInt(size);
			boolean bispo2 = false;
			// mesmo procedimento que foi feito para o bispo1
			while (!bispo2) {
				// neste caso e avaliado se o Bispo2 esta a ser atacado pela
				// Torre1
				// e pelo Bispo1
				if ((yBispo2 == (yTorre1 + (xTorre1 - xBispo2)))
						|| (yBispo2 == (yTorre1 + (xBispo2 - xTorre1)))
						|| (yBispo2 == yTorre1 || xBispo2 == xTorre1)
						|| (yBispo2 == (yBispo1 + (xBispo1 - xBispo2)))
						|| (yBispo2 == (yBispo1 + (xBispo2 - xBispo1)))) {
					xBispo2 = random.nextInt(size);
					yBispo2 = random.nextInt(size);
				} else {
					// caso nao, o progrmaa prossegue
					xadrez[xBispo2][yBispo2] = 'B';
					bispo2 = true;
				}
			}

			int xTorre2 = random.nextInt(size);
			int yTorre2 = random.nextInt(size);
			boolean torre2 = false;
			// mesmo procedimento que foi feito para as outras peças
			while (!torre2) {
				// neste caso e avaliado se a Torre2 esta a ser atacada pela
				// Torre1
				// e pelo Bispo1 e Bispo2
				if ((yBispo2 == (yTorre2 + (xTorre2 - xBispo2)))
						|| (yBispo2 == (yTorre2 + (xBispo2 - xTorre2)))
						|| (yBispo2 == yTorre2 || xBispo2 == xTorre2)
						|| (yBispo1 == (yTorre2 + (xTorre2 - xBispo1)))
						|| (yBispo1 == (yTorre2 + (xBispo1 - xTorre2)))
						|| (yBispo1 == yTorre2 || xBispo1 == xTorre2)
						|| (yTorre2 == yTorre1 || xTorre2 == xTorre1)) {
					xTorre2 = random.nextInt(size);
					yTorre2 = random.nextInt(size);
				} else {
					// caso nao, o progrmaa prossegue
					xadrez[xTorre2][yTorre2] = 'T';
					torre2 = true;
				}
			}
			// ciclo para avaliar todas as casa vazias se tem ataques
			for (int i = 0; i < xadrez.length; i++) {
				for (int j = 0; j < xadrez[i].length; j++) {
					// so serao avaliadas casas vazias
					if (xadrez[i][j] != 'B' && xadrez[i][j] != 'T') {
						// se for atacada pelo Bispo2
						if ((yBispo2 == (j + (i - xBispo2)))
								|| (yBispo2 == (j + (xBispo2 - i)))) {
							// incrementa 1 na variavel de total de ataques
							totalAttacks += 1;
						}
						// se for atacada pelo Bispo1
						if ((yBispo1 == (j + (i - xBispo1)))
								|| (yBispo1 == (j + (xBispo1 - i)))) {
							// incrementa 1 na variavel de total de ataques
							totalAttacks += 1;
						}
						// se for atacada pela Torre1
						if ((j == yTorre1 || i == xTorre1)) {
							// incrementa 1 na variavel de total de ataques
							totalAttacks += 1;
						}
						// se for atacada pela Torre2
						if ((j == yTorre2 || i == xTorre2)) {
							// incrementa 1 na variavel de total de ataques
							totalAttacks += 1;
						}
						// se o total de ataques for 0
						if (totalAttacks == 0) {
							// nessa casa aparecerá o char 'o'
							xadrez[i][j] = 'o';
						}
						// se o total de ataques for 1
						if (totalAttacks == 1) {
							// nessa casa aparecerá o char '-'
							xadrez[i][j] = '-';
						}
						// se o total de ataques for 2
						if (totalAttacks >= 2) {
							// nessa casa aparecerá o char '+'
							xadrez[i][j] = '+';
						}
						// reinicio da varial totalAttacks
						totalAttacks = 0;
					}
				}
			}

			// x
			System.out.println(" -------------------------------");
			for (int i = 0; i < xadrez.length; i++) {
				// y
				for (int j = 0; j < xadrez[i].length; j++) {
					if(j==0)System.out.print("| " + xadrez[i][j]);
					else
					System.out.print(" | " + xadrez[i][j]);
				}
				System.out.print(" |");
				System.out.println("");
			}
			System.out.println(" -------------------------------");
			if (keyboard.nextLine().equalsIgnoreCase("fim"))
				break;

		}

		keyboard.close();

	}
}
