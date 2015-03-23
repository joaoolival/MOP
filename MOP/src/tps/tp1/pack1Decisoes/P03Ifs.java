package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P03Ifs {

	public static void main(String[] args) {
		String yes = "yes";

		Scanner keyboard = new java.util.Scanner(System.in);

		System.out.println("think a letter between A and F, please awnser with yes or no ");
		System.out.println("is the letter after C?");

		if (keyboard.next().equals(yes)) {
			System.out.println("is the letter before F?");
			if (keyboard.next().equals(yes)) {
				System.out.println("is the letter before E?");
				if (keyboard.next().equals(yes)) {
					System.out.println("is the letter before D?");
					if (keyboard.next().equals(yes)) {
						System.out.println("well done, the letter is C");
					} else {
						System.out.println("well done, the letter is D");
					}
				} else {
					System.out.println("well done, the letter is E");
				}
			} else {
				System.out.println("well done, the letter is F");
			}
		}

		else {
			System.out.println("the letter is B?");
			if (keyboard.next().equals(yes)) {
				System.out.println("well done, the letter is B");
			} else {
				System.out.println("well done, the letter is A");

			}

		}
		keyboard.close();
	}

}
