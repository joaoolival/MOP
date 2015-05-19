package classcode.p14EDDLinkedLists.p5JavaLinkedLists;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Utiliza��o de java.util.LinkedList
 */

public class C02LinkedListDemo {

	public static <E> void printStatistics(Collection<E> c) {
		System.out.print(c);
		System.out.println(" Size = " + c.size());
	}

	public static <E> void printStatistics(Collection<E> c, String name) {
		System.out.print(name + " ");
		printStatistics(c);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] data = { "um", "dois", "tr�s", "quatro", "cinco", "seis",
				"sete", "oito", "nove", "dez" };

		// the list
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(data));

		printStatistics(list, "List");

		// verificar se existe e se existir remov�-lo pelo �ndice
		if (list.contains("oito")) {
			int i = list.indexOf("oito");
			list.remove(i);
			// mas pode haver mais que um oito
		}
		System.out.println("Ap�s remo��o do oito.");
		printStatistics(list, "List");

		// remover directamente
		list.remove("dois");
		System.out.println("Ap�s remo��o do dois.");
		printStatistics(list, "List");

		// obter um clone
		// LinkedList<String> list2 = (LinkedList<String>) list.clone();
		// Esta forma de obter um clone ser� a mais correcta, pois n�o se obt�m
		// um warning nem se faz um unchecked cast. Por isso, recomendo o seu
		// uso em vez de clone. Usa um CopyConstructor
		LinkedList<String> list2 = new LinkedList<String>(list);
		printStatistics(list2, "List2");
		// elimina��o de todos os elementos do clone, bad clone :)
		list2.clear();
		printStatistics(list2, "List2");
		printStatistics(list, "List");

		// listagem invertida por descending iterator
		Iterator<String> it = list.descendingIterator();
		System.out.println("listagem invertida por descending iterator: ");
		while (it.hasNext()) {
			System.out.print(it.next());
			if (it.hasNext())
				System.out.print(", ");
		}
		System.out.println();

		// mais opera��es
		list.addFirst("Zero");
		list.addLast("mil");
		printStatistics(list, "List");

		list.addAll(new LinkedList<String>(list));
		printStatistics(list, "List");

		LinkedList<String> list3 = new LinkedList<String>();
		list3.add("um");
		list3.add("dois");

		System.out.println("Depois de remover UM e DOIS");
		list.removeAll(list3);
		printStatistics(list, "List");

		// utiliza��o como stack
		System.out.println("\nLista as a stack");
		LinkedList<String> listStack = new LinkedList<String>();
		System.out.println("Push -> S1");
		listStack.push("S1");
		System.out.println("Push -> S2");
		listStack.push("S2");
		System.out.println("Push -> S3");
		listStack.push("S3");
		printStatistics(listStack, "ListStack");
		System.out.println("Pop, retorned -> " + listStack.pop());
		printStatistics(listStack, "ListStack");

		// utiliza��o como fifo
		System.out.println("\nLista as a fifo (put at tail, get at head)");
		LinkedList<String> listFifo = new LinkedList<String>();
		System.out.println("Put -> S1");
		listFifo.addLast("S1");
		System.out.println("Put -> S2");
		listFifo.addLast("S2");
		System.out.println("Put -> S3");
		listFifo.addLast("S3");
		printStatistics(listFifo, "listFifo");
		System.out.println("Get, returned -> " + listFifo.removeFirst());
		printStatistics(listFifo, "ListFifo");

		// extra do teste
		List<Integer> listx = new LinkedList<Integer>();
		listx.add(new Integer(10));
		listx.add(20);
		Iterator<Integer> itx = listx.iterator();
		// itx.remove();
		System.out.println(itx.next());

		// Collections.addAll
		Collections.addAll(listx, 10, 20, 30);
		System.out.println(listx);
	}
}
