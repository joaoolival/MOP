package tps.tp2.pack1Recursive;

import java.util.Arrays;

public class P02ArraysSymmetric {

	/**
	 * Main
	 */
	public static void main(String[] args) {

		// getLastElement ==========================================

		char[] n = { 'a' };
		char res = getLastElement(n);
		System.out.println("getLastElement of " + Arrays.toString(n) + "  = "
				+ res);

		n = new char[] { 'a', 'b' };
		res = getLastElement(n);
		System.out.println("getLastElement of " + Arrays.toString(n) + "  = "
				+ res);

		n = new char[] { 'a', 'b', 'a' };
		res = getLastElement(n);
		System.out.println("getLastElement of " + Arrays.toString(n) + "  = "
				+ res);

		// isSymmetric ==========================================

		n = new char[] { 'a' };
		boolean res3 = isSymmetric(n);
		System.out.println("isSymmetric of " + Arrays.toString(n) + "  = "
				+ res3);

		n = new char[] { 'a', 'a' };
		res3 = isSymmetric(n);
		System.out.println("isSymmetric of " + Arrays.toString(n) + "  = "
				+ res3);

		n = new char[] { 'a', 'c' };
		res3 = isSymmetric(n);
		System.out.println("isSymmetric of " + Arrays.toString(n) + "  = "
				+ res3);

		n = new char[] { 'a', 'b', 'a' };
		res3 = isSymmetric(n);
		System.out.println("isSymmetric of " + Arrays.toString(n) + "  = "
				+ res3);

		n = new char[] { 'a', 'b', 'c' };
		res3 = isSymmetric(n);
		System.out.println("isSymmetric of " + Arrays.toString(n) + "  = "
				+ res3);

		n = new char[] { 'a', 'b', 'a', 'd' };
		res3 = isSymmetric(n);
		System.out.println("isSymmetric of " + Arrays.toString(n) + "  = "
				+ res3);

	}

	// Output desejado:
	// getLastElement of [a] = a
	// getLastElement of [a, b] = b
	// getLastElement of [a, b, a] = a
	// isSymmetric of [a] = true
	// isSymmetric of [a, a] = true
	// isSymmetric of [a, c] = false
	// isSymmetric of [a, b, a] = true
	// isSymmetric of [a, b, c] = false
	// isSymmetric of [a, b, a, d] = false

	/**
	 * Devolve último elemento de um array, o elemento de maior índice. Só pode
	 * aceder ao elemento do array de índcie 0, array[0]. Pode utilizar o método
	 * Arrays.copyOfrange.
	 */
	public static char getLastElement(char[] array) {
		if (array == null || array.length == 0)
			throw new NullPointerException();

		// TODO
		return '-';
	}

	/**
	 * Devolve verdadeiro se o array recebido for simétrico, ou seja, é um array
	 * idêntico se lido do início para o fim ou em sentido inverso. Este método
	 * deve utilizar getLastElement na sua implementação. Pode utilizar o método
	 * Arrays.copyOfrange.
	 */
	public static boolean isSymmetric(char[] array) {
		if (array == null)
			throw new NullPointerException("Null argument.");

		// true if length is 0 or 1
		
		// TODO
		return false;
	}
}
