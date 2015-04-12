package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P04OpTernário {

	public static void main(String[] args) {

		System.out
				.print("Introduza uma coordenada geográfica de Norte, Sul, Este ou Oeste. ");
		Scanner keyboard = new Scanner(System.in);

		/*
		 * Ini da variável coordenada como string, tomando o valor da palavra
		 * introduzida pelo utilizador
		 */
		String coordenada = keyboard.next();
		/*
		 * Tira os espaços da string coordenada caso o utilizador os tenha feito
		 * e converte todas as letras para minusculas
		 */
		coordenada = coordenada.trim().toLowerCase();
		// ini de mais duas strings
		String proximaCoordenadaHorario;
		String proximaCoordenadaAntiHorario;

		/*
		 * Valor da proximaCoordenadaHorario irá depender da coordenada inserida
		 * pelo utilizador. Se a coordenada inserida for Norte a
		 * proximaCoordenadaHorario irá ser Este, caso a coordenada seja este a
		 * proximaCoordenadaHorario irá ser sul, caso a coordenada seja sul a
		 * proximaCoordenadaHorario irá ser oeste, caso a coordenada seja oeste
		 * a proximaCoordenadaHorario irá ser norte.
		 */
		proximaCoordenadaHorario = (coordenada.equals("norte")) ? "Este"
				: (coordenada.equals("este")) ? "Sul" : (coordenada
						.equals("sul")) ? "Oeste"
						: (coordenada.equals("oeste")) ? "Norte" : "erro";

		/*
		 * Valor da proximaCoordenadaAntiHorario irá depender da coordenada
		 * inserida pelo utilizador. Se a coordenada inserida for Norte a
		 * proximaCoordenadaAntiHorario irá ser oeste, caso a coordenada seja
		 * oeste a proximaCoordenadaAntiHorario irá ser sul, caso a coordenada
		 * seja sul a proximaCoordenadaAntiHorario irá ser este, caso a
		 * coordenada seja este a proximaCoordenadaAntiHorario irá ser norte.
		 */
		proximaCoordenadaAntiHorario = (coordenada.equals("norte")) ? "Oeste"
				: (coordenada.equals("oeste")) ? "Sul" : (coordenada
						.equals("sul")) ? "Este"
						: (coordenada.equals("este")) ? "Norte" : "erro";

		/*
		 * Mensagem que com os valores das variáveis proximaCoordenadaHorario e
		 * proximaCoordenadaAntiHorario
		 */
		System.out.println("A coordenada seguinte no sentido horário é "
				+ proximaCoordenadaHorario
				+ " e a coordenada seguinte no sentido anti-horário é "
				+ proximaCoordenadaAntiHorario);

		keyboard.close();

	}

}
