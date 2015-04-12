package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P05Switch {

	public static void main(String[] args) {
		System.out.print("Introduza o n�mero do m�s -> ");
		// ini do Scanner
		Scanner keyboard = new Scanner(System.in);

		// ini das vari�veis string
		String strTotalParcial = null;
		String nomeMes = null;
		String nomeEstacao = null;

		// ini da vari�vel numMes que toma um numero inteiro inserido pelo
		// utilizador
		int numMes = keyboard.nextInt();

		/*
		 * Se o n�mero inserido pelo utilizador for menor que 1 e maior que 12,
		 * ir� aparecer na consola uma mensagem de erro e o programa termina.
		 */
		if ((numMes < 1) || (numMes > 12)) {
			System.out.println("Erro! O n�mero do m�s inserido � inv�lido! "
					+ "O programa vai terminar!");
			keyboard.close();
			System.exit(1);
		}

		/*
		 * Caso o n�mero inteiro inserido esteja entre 1 e 12, o switch ir�
		 * atualizar as vari�veis strings de acordo com o valor inserido.
		 */
		switch (numMes) {
		case 1:
			nomeMes = "Janeiro";
			strTotalParcial = "na totalidade";
			nomeEstacao = "do Inverno";
			break;
		case 2:
			nomeMes = "Fevereiro";
			strTotalParcial = "na totalidade";
			nomeEstacao = "do Inverno";
			break;
		case 3:
			nomeMes = "Mar�o";
			strTotalParcial = "principalmente";
			nomeEstacao = "do Inverno";
			break;
		case 4:
			nomeMes = "Abril";
			strTotalParcial = "na totalidade";
			nomeEstacao = "da Primavera";
			break;
		case 5:
			nomeMes = "Maio";
			strTotalParcial = "na totalidade";
			nomeEstacao = "da Primavera";
			break;
		case 6:
			nomeMes = "Junho";
			strTotalParcial = "principalmente";
			nomeEstacao = "da Primavera";
			break;
		case 7:
			nomeMes = "Julho";
			strTotalParcial = "na totalidade";
			nomeEstacao = "do Ver�o";
			break;
		case 8:
			nomeMes = "Agosto";
			strTotalParcial = "na totalidade";
			nomeEstacao = "do Ver�o";
			break;
		case 9:
			nomeMes = "Setembro";
			strTotalParcial = "principalmente";
			nomeEstacao = "do Ver�o";
			break;

		case 10:
			nomeMes = "Outubro";
			strTotalParcial = "na totalidade";
			nomeEstacao = "do Outono";
			break;
		case 11:
			nomeMes = "Novembro";
			strTotalParcial = "na totalidade";
			nomeEstacao = "do Outono";
			break;
		case 12:
			nomeMes = "Dezembro";
			strTotalParcial = "principalmente";
			nomeEstacao = "do Outono";
			break;
		}

		/*
		 * Mensagem que ir� aparecer na consola com o resultado das vari�veis
		 * strings atualizadas no switch
		 */
		System.out.print("O m�s " + numMes + " � o m�s de " + nomeMes
				+ " e pertence " + strTotalParcial + " � esta��o "
				+ nomeEstacao + ".");

		keyboard.close();

	}

}
