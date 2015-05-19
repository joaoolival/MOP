package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Agora o m�todo DIVISAO tem de declarar que pode lan�ar a excep��o Exception e
 * o m�todo METODO1 tem de declarar que pode lan�ar a a excep��o
 * NegativeValueException. Deste modo quem usar estes m�todos sabe com o que
 * pode esperar.
 * 
 */
public class C11HandleExceptionsOutsideTheMethod2 {

	/**
	 * M�todo base
	 */
	public static int divisao(int dividendo, int divisor) throws Exception {
		if (divisor == 0)
			throw new Exception("Divisao por zero");
		int quociente = dividendo / divisor;
		return quociente;
	}

	/**
	 * m�todo que utiliza o m�todo base
	 */
	public static int metodo1(int dividendo, int divisor)
			throws NegativeValueException {
		if (divisor < 0)
			throw new NegativeValueException("Divisor negativo.");
		try {
			return divisao(dividendo, divisor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * main
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner keyboard = new Scanner(System.in);
		do {

			System.out.println("Realizacao da operacao de divisao...");

			try {
				System.out.print("Introduza o dividendo -> ");
				int dividendo = keyboard.nextInt();

				System.out.print("Introduza o divisor -> ");
				int divisor = keyboard.nextInt();

				// realizar a processamento
				int quociente = metodo1(dividendo, divisor);
				// subsituir a linha anterior pela seguinte, observar a
				// informa��o do compilador
				// int quociente = divisao(dividendo, divisor);

				// mostrar resultado
				System.out.println("Divisao de " + dividendo + " por "
						+ divisor + " -> " + quociente);

			} catch (NegativeValueException e) {
				System.out.println("Ocorreu a excepcao: "
						+ e.getClass().getSimpleName() + ": " + e.getMessage());
			}
		} while (NegativeValueException.getN() < 2);

		keyboard.close();
	}
	// finally??
	// isto quer dizer que cheg�mos ao fim????
}