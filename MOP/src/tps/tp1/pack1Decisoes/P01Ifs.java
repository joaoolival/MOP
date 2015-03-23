package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P01Ifs {

	public static void main(String[] args) {
		Scanner keyboard = new java.util.Scanner(System.in);

		System.out.println("Insert a number bigger than 10 -> ");

		int val = keyboard.nextInt();

		if (val <= 10) {
			System.out.println("try again!");
		}

		else {
			int quotient = val / 7;
			int rest = val % 7;
			System.out.println("well done!");
			System.out.println("the quotient is " + quotient
					+ " and the rest is " + rest);
		}

		keyboard.close();

	}

}
