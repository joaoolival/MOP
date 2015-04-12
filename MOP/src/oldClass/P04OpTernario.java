package oldClass;

import java.util.Scanner;

public class P04OpTernario {

	public static void main(String[] args) {
		Scanner keyboard = new java.util.Scanner(System.in);

		System.out.println("Insert 1 cardinal point -> north, south, east or west? ");

		String cardinalPoint = keyboard.next();
		String horario;
		horario = (cardinalPoint.equals("north")) ? "east" : (cardinalPoint
				.equals("east")) ? "south"
				: (cardinalPoint.equals("south")) ? "west" : "north";

		String antiHorario;
		antiHorario = (cardinalPoint.equals("north")) ? "west" : (cardinalPoint
				.equals("west")) ? "south"
				: (cardinalPoint.equals("south")) ? "east" : "north";

		System.out.println("if you look to " + cardinalPoint
				+ " on your right is the " + horario + " and on your left is "
				+ antiHorario);
		keyboard.close();
	}
}
