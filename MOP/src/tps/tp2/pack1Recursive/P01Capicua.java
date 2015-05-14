package tps.tp2.pack1Recursive;

public class P01Capicua {

	/**
	 * Main
	 */
	public static void main(String[] args) {
		int n = 1;
		int res = getLastDigit(n);
		System.out.println("getLastDigit of " + n + "  = " + res);

		n = 25;
		res = getLastDigit(n);
		System.out.println("getLastDigit of " + n + "  = " + res);

		n = 359;
		res = getLastDigit(n);
		System.out.println("getLastDigit of " + n + "  = " + res);

		n = 4;
		res = remLastDigit(n);
		System.out.println("remLastDigit of " + n + "  = " + res);

		n = 25;
		res = remLastDigit(n);
		System.out.println("remLastDigit of " + n + "  = " + res);

		n = 359;
		res = remLastDigit(n);
		System.out.println("remLastDigit of " + n + "  = " + res);

		n = 4;
		boolean isCap = isCapicua(n);
		System.out.println("isCapicua of " + n + "  = " + isCap);

		n = 22;
		isCap = isCapicua(n);
		System.out.println("isCapicua of " + n + "  = " + isCap);

		n = 23;
		isCap = isCapicua(n);
		System.out.println("isCapicua of " + n + "  = " + isCap);

		n = 757;
		isCap = isCapicua(n);
		System.out.println("isCapicua of " + n + "  = " + isCap);

		n = 75677;
		isCap = isCapicua(n);
		System.out.println("isCapicua of " + n + "  = " + isCap);

	}

	// Output desejado:
	// getLastDigit of 1 = 1
	// getLastDigit of 25 = 2
	// getLastDigit of 359 = 3
	// remLastDigit of 4 = 0
	// remLastDigit of 25 = 5
	// remLastDigit of 359 = 59
	// isCapicua of 4 = true
	// isCapicua of 22 = true
	// isCapicua of 23 = false
	// isCapicua of 757 = true
	// isCapicua of 75677 = false

	/**
	 * Devolve o dígito de maior peso do número recebido.
	 */
	public static int getLastDigit(int num) {
		if (num < 0)
			throw new IllegalArgumentException("Argumento de valor negativo: "
					+ num);
		if(num < 10) return num;
		return getLastDigit(num/10);
	}

	/**
	 * Devolve o número recebido mas sem o seu dígito de maior peso. Caso o
	 * número seja menor que dez deve devolver zero.
	 */
	public static int remLastDigit(int num) {
		if (num < 0)
			throw new IllegalArgumentException("Argumento de valor negativo: "
					+ num);

		if (num < 10) return 0;
	
		
		return ((num%10) + remLastDigit(num/10)*10);
	}

	/**
	 * Devolve verdadeiro se o número recebido for uma capicua, ou seja, é um
	 * número que lido da frente para trás é o mesmo número que lido em sentido
	 * inverso. Este método deve utilizar os outros na sua implementação.
	 */
	// 26562
	public static boolean isCapicua(int num) {
		if (num < 0)
			throw new IllegalArgumentException("Argumento de valor negativo: "
					+ num);
		if(num < 10) return true;
		
		if(getLastDigit(num) != num%10){
			return false;
		}
		return isCapicua(remLastDigit(num)/10);
	}

}
