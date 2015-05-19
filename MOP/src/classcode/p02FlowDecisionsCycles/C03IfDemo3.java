package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

public class C03IfDemo3 {

	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read an integer
		System.out.print("Introduza um n�mero inteiro positivo: ");
		int num = keyboard.nextInt();

		// if with other if inside - nested ifs
		if (num >= 0) {
			System.out.println("O n�mero " + num + " � um n�mero positivo");
			System.out.print("O n�mero " + num + " � um n�mero ");
			if (num % 2 == 0)
				System.out.println("par");
			else
				System.out.println("impar");
		}

		// close the keyboard
		keyboard.close();
	}

}
