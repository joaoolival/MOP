package classcode.p10ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * V�rios blocos de TRY
 * 
 */
public class C07SeveralTryBlocks {

	/**
	 * main
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Realizacao da operacao de divisao...");

		try {
			boolean success = false;
			do {
				try {
					System.out.print("Introduza o dividendo -> ");
					int dividendo = keyboard.nextInt();

					System.out.print("Introduza o divisor -> ");
					int divisor = keyboard.nextInt();

					// realizar a processamento
					int quociente = dividendo / divisor;

					// mostrar resultado
					System.out.println("Divisao de " + dividendo + " por "
							+ divisor + " -> " + quociente);
					// gerar uma excep��o
					if (quociente % 2 == 1)
						"ola".charAt(10);
					success = true;
				} catch (ArithmeticException e) {
					System.err
							.println("Ocorreu a excepcao de divis�o por zero: "
									+ e.getMessage());
					// gerar uma excep��o
					"ola".charAt(10);
				} catch (InputMismatchException e) {
					System.err.println("Ocorreu a excepcao de Input Mismatch");
					// eliminar inout errado
					keyboard.nextLine();
				}
				if (!success)
					System.out.println("A opera��o ser� repetida.\n");
			} while (!success);
		} catch (Exception e) {
			System.err.println("Ocorreu a excepcao: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Fim de programa...");

		keyboard.close();
	}
	// a excep��o � avaliada e ficar� entregue ao primeiro catch que seja do seu
	// tipo.

	// e mais excep��es!!!
}
