package classcode.p10ExceptionHandling;

/**
 * Agora o m�todo DIVISAO tem de declarar que pode lan�ar a excep��o Exception e
 * o m�todo METODO1 tem de declarar que pode lan�ar a a excep��o
 * NegativeValueException. Deste modo quem usar estes m�todos sabe com o que
 * pode esperar.
 * 
 */
public class C21Catch {

	/**
	 * M�todo base
	 */
	public static int divisao(int dividendo, int divisor) {
		// try {
		if (divisor == 0)
			throw new RuntimeException("Divisao por zero");
		System.out.println("jhgjhhjjh");
		// } catch (Exception e) {
		// divisor = 1;
		// }
		int quociente = dividendo / divisor;
		return quociente;
	}

	/**
	 * m�todo que utiliza o m�todo base
	 */
	public static int metodo1(int dividendo, int divisor) {

		return divisao(dividendo, divisor);
	}

	/**
	 * main
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			metodo1(10, 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}