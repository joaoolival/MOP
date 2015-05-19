package classcode.p10ExceptionHandling;

public class C01ExceptionInConstructor {

	/**
	 * main
	 */
	public static void main(String[] args) {

		// teste 3 - descomentar
		// String s = null;
		// s.toString();

		System.out.println("In�cio do main...");
		System.out.println("Vamos criar o o objecto.");

		// teste 1
		MultipleStrings ms = new MultipleStrings(-1);

		// teste 2- comentar a linha anterior e descomentar a linha seguinte
		// MultipleStrings ms = new MultipleStrings(10);

		System.out.println("Objecto criado. Vamos inserir strings.");
		ms.addString("um");
		ms.addString("dois");
		System.out.print("Conte�do do objecto: ");
		System.out.println(ms);
	}
}

class MultipleStrings {
	String[] strings;
	int nStrings = 0;

	/**
	 * Constructor
	 */
	MultipleStrings(int nStrings) {
		if (nStrings < 0) {
			// criar uma excep��o da classe RuntimException
			RuntimeException e = new RuntimeException(
					"Construtor de MultipleStrings chamado com n de String menor que zero -> "
							+ nStrings);

			System.out.println("Excep��o criada -> " + e);
			// lan�ar a excep��o
			throw e;
		}
		strings = new String[nStrings];
	}

	/**
	 * adiciona uma string se houver espa�o
	 */
	public boolean addString(String s) {
		if (nStrings > strings.length)
			return false;
		strings[nStrings++] = s;
		return true;
	}

	/**
	 * devolve a representa��o do objecto numa string
	 */
	public String toString() {
		// uso de StringBuilder para optimizar a constru��o da string
		StringBuilder sb = new StringBuilder(100);
		sb.append("[");
		for (int i = 0; i < nStrings; i++) {
			if (i > 0)
				sb.append(", ");
			sb.append(strings[i]);
		}
		sb.append("]");
		return sb.toString();
	}
}
