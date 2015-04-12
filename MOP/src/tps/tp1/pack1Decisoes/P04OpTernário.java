package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P04OpTern�rio {

	public static void main(String[] args) {

		System.out
				.print("Introduza uma coordenada geogr�fica de Norte, Sul, Este ou Oeste. ");
		Scanner keyboard = new Scanner(System.in);

		/*
		 * Ini da vari�vel coordenada como string, tomando o valor da palavra
		 * introduzida pelo utilizador
		 */
		String coordenada = keyboard.next();
		/*
		 * Tira os espa�os da string coordenada caso o utilizador os tenha feito
		 * e converte todas as letras para minusculas
		 */
		coordenada = coordenada.trim().toLowerCase();
		// ini de mais duas strings
		String proximaCoordenadaHorario;
		String proximaCoordenadaAntiHorario;

		/*
		 * Valor da proximaCoordenadaHorario ir� depender da coordenada inserida
		 * pelo utilizador. Se a coordenada inserida for Norte a
		 * proximaCoordenadaHorario ir� ser Este, caso a coordenada seja este a
		 * proximaCoordenadaHorario ir� ser sul, caso a coordenada seja sul a
		 * proximaCoordenadaHorario ir� ser oeste, caso a coordenada seja oeste
		 * a proximaCoordenadaHorario ir� ser norte.
		 */
		proximaCoordenadaHorario = (coordenada.equals("norte")) ? "Este"
				: (coordenada.equals("este")) ? "Sul" : (coordenada
						.equals("sul")) ? "Oeste"
						: (coordenada.equals("oeste")) ? "Norte" : "erro";

		/*
		 * Valor da proximaCoordenadaAntiHorario ir� depender da coordenada
		 * inserida pelo utilizador. Se a coordenada inserida for Norte a
		 * proximaCoordenadaAntiHorario ir� ser oeste, caso a coordenada seja
		 * oeste a proximaCoordenadaAntiHorario ir� ser sul, caso a coordenada
		 * seja sul a proximaCoordenadaAntiHorario ir� ser este, caso a
		 * coordenada seja este a proximaCoordenadaAntiHorario ir� ser norte.
		 */
		proximaCoordenadaAntiHorario = (coordenada.equals("norte")) ? "Oeste"
				: (coordenada.equals("oeste")) ? "Sul" : (coordenada
						.equals("sul")) ? "Este"
						: (coordenada.equals("este")) ? "Norte" : "erro";

		/*
		 * Mensagem que com os valores das vari�veis proximaCoordenadaHorario e
		 * proximaCoordenadaAntiHorario
		 */
		System.out.println("A coordenada seguinte no sentido hor�rio � "
				+ proximaCoordenadaHorario
				+ " e a coordenada seguinte no sentido anti-hor�rio � "
				+ proximaCoordenadaAntiHorario);

		keyboard.close();

	}

}
