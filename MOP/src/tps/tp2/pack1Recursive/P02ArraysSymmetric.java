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

		n = new char[] { 'a', 'b','a' };
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
	 * Devolve �ltimo elemento de um array, o elemento de maior �ndice. S� pode
	 * aceder ao elemento do array de �ndcie 0, array[0]. Pode utilizar o m�todo
	 * Arrays.copyOfrange.
	 */
	public static char getLastElement(char[] array) {
		if (array == null || array.length == 0)
			throw new NullPointerException();

		if(array.length == 1) return array[0];
		
		return getLastElement(Arrays.copyOfRange(array,1,array.length));
	}



	/**
	 * Devolve verdadeiro se o array recebido for sim�trico, ou seja, � um array
	 * id�ntico se lido do in�cio para o fim ou em sentido inverso. Este m�todo
	 * deve utilizar getLastElement na sua implementa��o. Pode utilizar o m�todo
	 * Arrays.copyOfrange.
	 */
	public static boolean isSymmetric(char[] array) {
		if (array == null)
			throw new NullPointerException("Null argument.");

		if (array.length < 2) return true;
		
		if(array[0] != getLastElement(array))
			return false;
		
		return isSymmetric(Arrays.copyOfRange(array, 1, array.length-1));
	}
}
