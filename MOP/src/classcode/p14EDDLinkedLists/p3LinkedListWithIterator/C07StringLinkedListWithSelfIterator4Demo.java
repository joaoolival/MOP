package classcode.p14EDDLinkedLists.p3LinkedListWithIterator;

import java.util.Iterator;

/**
 * Com esta demo pretende-se demonstrar que a utiliza��o de iteradores gera
 * excep��es de concurrent modification quando um iterador est� a iterarar e
 * ocorre uma altera��o na lista fora da interface Iterator e no iterador em
 * quest�o.
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class C07StringLinkedListWithSelfIterator4Demo {
	public static void main(String[] args) {

		C06StringLinkedListWithSelfIterator4<String> stringList = new C06StringLinkedListWithSelfIterator4<String>();

		System.out.println("Lista de String ...");
		stringList.addANodeToStart("Hello");
		stringList.addANodeToStart("Good-bye");

		System.out.println("\nListagem da lista:");
		stringList.showList();

		Iterator<String> it1 = stringList.iterator();
		@SuppressWarnings("unused")
		Iterator<String> it2 = stringList.iterator();

		it1.next();
		it1.remove();
		// it2.next(); // teste1 - depois, comentar para ver teste 2
		// excep��o devido a altera��o atrav�s de iterador concorrente

		stringList.addANodeToStart("Hello");
		it1.next(); // teste 2 - excep��o por altera��o concorrente
		// mas devido a inser��o directa na lista

	}
}
