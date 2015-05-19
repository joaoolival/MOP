package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Apanhar tamb�m as excep��es de input. Colocar no input a letra: A
 * 
 */
public class C04AnotherException {

	/**
	 * main
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Realizacao da operacao de divisao...");

		try {
			System.out.print("Introduza o dividendo -> ");
			input.close();
			int dividendo = input.nextInt();

			System.out.print("Introduza o divisor -> ");
			int divisor = input.nextInt();

			// realizar a processamento
			int quociente = dividendo / divisor;

			// mostrar resultado
			System.out.println("Divisao de " + dividendo + " por " + divisor
					+ " -> " + quociente);

		} catch (Exception e) {
			// getSimpleName devolve s� o nome da classe
			System.err.println("Ocorreu a excep��o: "
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}
	// e como diferenciar as excep��es ocorridas?
}
