package classcode.p14EDDLinkedLists.p4DoubleLinkedList;

import java.util.ListIterator;

/**
 * Com esta demo pretende-se demonstrar que a utiliza��o de iteradores gera
 * excep��es de concurrent modification quando um iterador est� a iterarar e
 * ocorre uma altera��o na lista fora da interface Iterator e no iterador em
 * quest�o.
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class C03DLinkedListWithListIteratorDemo {
	public static void main(String[] args) {

		C02DLinkedListWithListIterator<String> stringList = new C02DLinkedListWithListIterator<String>();

		ListIterator<String> it = stringList.listIterator();

		System.out.println("Lista de String ...");
		it.add("Hello");
		it.next();
		it.add("Good-bye");

		System.out.println("Listagem da lista: " + stringList);

		System.out.println("Listagem invertida da lista: "
				+ stringList.toStringInverted());

		System.out.println();
		//it.next(); // erro porque a inser��o foi antes do elemento, logo o
					// current esta no fim da lista
		
		// remove all elements
		ListIterator<String> it2 = stringList.listIterator();
		System.out.println("Remo��o de todos os elementos da lista.");
		while(it2.hasNext()) {
			String elem = it2.next();
			it2.remove();
			System.out.println("Removeu o elemento -> " + elem);
		}
	}
}
