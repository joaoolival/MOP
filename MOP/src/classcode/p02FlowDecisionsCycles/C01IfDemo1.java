package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

public class C01IfDemo1 {

	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read an integer
		System.out.print("Introduza um n�mero inteiro: ");
		int num = keyboard.nextInt();

		// print if it is positive or negative
		if (num >= 0)
			System.out.println("O n�mero " + num + " � um n�mero positivo");
		else
			System.out.println("O n�mero " + num + " � um n�mero negativo");

		// close the keyboard
		keyboard.close();
	}

}
