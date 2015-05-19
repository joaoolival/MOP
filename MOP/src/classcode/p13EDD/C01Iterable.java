package classcode.p13EDD;

import java.util.Arrays;
import java.util.Iterator;

public class C01Iterable {

	/**
	 * M�todo que recebe algo Iterable e vai iterar sobre os elementos
	 */
	public static void printIterable(Iterable<String> container) {
		// obt�m o iterador
		Iterator<String> it = container.iterator();
		System.out.print("[");
		// pergunta se h� mais elementos
		while (it.hasNext()) {
			// obt�m o pr�ximo elemento e mostra-o
			System.out.print(it.next());
			if (it.hasNext())
				System.out.print(", ");
		}
		System.out.println("]");
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		// Arrays.asList cria um array com os elementos e devolve uma List de
		// tamanho fixo com esses valores
		Iterable<String> itStrings = Arrays.asList("um", "dois", "tr�s",
				"quatro");
		// List<String> g;

		// chamar o m�todo que vai iterar sobre os elementos
		printIterable(itStrings);
	}

}
