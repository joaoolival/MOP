package classcode.p14EDDLinkedLists.p1LinkedList;

/**
 * Primeira vers�o da list simples. Utiliza a nested class Node (tamb�m
 * designada de inner class)
 * 
 * Ver classe InnerClasses sobre explica��es acerca de inner classes
 * 
 * S� implementa alguns m�todos, deixa os outros para os alunos se divertirem.
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class C02StringLinkedList {
	protected Node head;

	public C02StringLinkedList() {
		head = null;
	}

	/**
	 * Adds a node at the start of the list. The added node has addData as its
	 * data. The added node will be the first node in the list.
	 */
	public void addANodeToHead(String addData) {
		head = new Node(addData, head);
	}

	/**
	 * Deletes head node
	 * 
	 */
	public String deleteHeadNode() {
		String str = null;
		if (head != null) {
			str = head.data;
			head = head.link;
		}
		return str;
	}

	/**
	 * Adds a node at the tail of the list. The added node has addData as its
	 * data. The added node will be the last node in the list.
	 */
	public void addANodeToTail(String addData) {
		Node newNode = new Node(addData, null);
		if (head == null) {
			head = newNode;
		} else {
			Node aux = head;
			while (aux.link != null) {
				aux = aux.link;
			}
			aux.link = newNode;
		}
	}

	/**
	 * Deletes tail node
	 * 
	 */
	public String deleteTailNode() {
		String str = null;
		if (head == null) {
			return null;
		}
		if (head.link == null) {
			// remocao do �nico elemento
			str = head.data;
			head = null;
		} else {
			// remocao normal do �ltimo elemento
			Node aux = head.link;
			Node previous = head;
			while (aux.link != null) {
				previous = aux;
				aux = aux.link;
			}
			str = aux.data;
			previous.link = null;
		}
		return str;
	}

	/**
	 * Shows the list
	 */
	public void showList() {
		Node aux = head;
		while (aux != null) {
			System.out.print(aux.data);
			aux = aux.link;
			if (aux != null)
				System.out.print(", ");
		}
		System.out.println();
	}

	// pos = 0, refere-se ao primeiro elemento da lista
	public String getElementAt(int pos) {
		Node currElem = head;
		for (int i = 0; i < pos; i++) {
			if (currElem == null)
				return null;
			currElem = currElem.link;
		}
		return currElem == null ? null : currElem.data;
	}

	public boolean insertAt(String str, int pos) {
		if (pos < 0)
			throw new IllegalArgumentException("index negativo");
		if (pos == 0) {
			head = new Node(str, head);
			return true;
		}
		Node aux = head;
		for (int i = 0; i < pos - 1; i++) {
			if (aux == null)
				return false;
			aux = aux.link;
		}
		if (aux == null)
			return false;
		aux.link = new Node(str, aux.link);
		return true;
	}

	public String removeAt(int pos) {
		if (pos < 0)
			throw new IllegalArgumentException("index negativo");
		if (pos == 0) {
			if (head == null)
				return null;
			String str = head.data;
			head = head.link;
			return str;
		}
		Node aux = head;
		for (int i = 0; i < pos - 1; i++) {
			if (aux == null)
				return null;
			aux = aux.link;
		}
		if (aux.link == null)
			return null;
		String str = aux.link.data;
		aux.link = aux.link.link;
		return str;
	}

	/**
	 * Devolver o index da primeira string igual ao argumento passado Devolve -1
	 * caso n�o encontre
	 */
	public int IndexOf(String str) {
		Node currElem = head;
		int index = 0;
		while (currElem != null) {
			if (currElem.data != null && currElem.data.equals(str))
				return index;
			currElem = currElem.link;
			index++;
		}
		return -1;
	}

	// remove e devolve a primeira ocorr�ncia do argumento recebido
	// caso n�o encontre devolve null
	public String removeElement(String str) {
		if (head == null)
			return null;

		// remo��o � cabe�a
		if (head != null && head.data != null && head.data.equals(str)) {
			head = head.link;
			return str;
		}
		// remo��o no meio ou fim da lista
		Node previous = head;
		while (previous.link != null) {
			if (previous.link.data != null && previous.link.data.equals(str)) {
				previous.link = previous.link.link;
				return str;
			}
			previous = previous.link;
		}
		return null;
	}

	protected class Node {
		public String data;
		public Node link;

		public Node() {
			link = null;
			data = null;
		}

		public Node(String newData, Node linkValue) {
			data = newData;
			link = linkValue;
		}

		public String toString() {
			return data;
		}
	}

	private void printList(String prefix) {
		System.out.print(prefix);
		showList();
		System.out.println();
	}

	public static void main(String[] args) {
		C02StringLinkedList list = new C02StringLinkedList();
		System.out.println("Element at 0 -> " + list.getElementAt(0));
		list.addANodeToHead("One");
		list.addANodeToHead("Two");
		list.addANodeToHead("Three");
		list.showList();
		System.out.println();

		System.out.println("Element at 0 -> " + list.getElementAt(0));
		System.out.println("Element at 1 -> " + list.getElementAt(1));
		System.out.println("Element at 2 -> " + list.getElementAt(2));
		System.out.println("Element at 3 -> " + list.getElementAt(3));

		list.deleteHeadNode();
		list.deleteHeadNode();
		list.deleteHeadNode();

		list.printList("List -> ");

		System.out.println("InsertAt test====================");
		String str = "um";
		int pos = 0;
		System.out.println("InsertAt " + str + " at " + pos + " -> "
				+ list.insertAt(str, pos));
		list.printList("List -> ");

		str = "dois";
		pos = 0;
		System.out.println("InsertAt " + str + " at " + pos + " -> "
				+ list.insertAt(str, pos));
		list.printList("List -> ");

		str = "tres";
		pos = 1;
		System.out.println("InsertAt " + str + " at " + pos + " -> "
				+ list.insertAt(str, pos));
		list.printList("List -> ");

		str = "quatro";
		pos = 3;
		System.out.println("InsertAt " + str + " at " + pos + " -> "
				+ list.insertAt(str, pos));
		list.printList("List -> ");

		System.out.println("removeAt test====================");
		pos = 2;
		System.out.println("RemoveAt " + " at " + pos + " -> "
				+ list.removeAt(pos));
		list.printList("List -> ");

		pos = 0;
		System.out.println("RemoveAt " + " at " + pos + " -> "
				+ list.removeAt(pos));
		list.printList("List -> ");

		pos = 1;
		System.out.println("RemoveAt " + " at " + pos + " -> "
				+ list.removeAt(pos));
		list.printList("List -> ");

		pos = 0;
		System.out.println("RemoveAt " + " at " + pos + " -> "
				+ list.removeAt(pos));
		list.printList("List -> ");

		str = "quatro";
		pos = 0;
		System.out.println("InsertAt " + str + " at " + pos + " -> "
				+ list.insertAt(str, pos));
		list.printList("List -> ");

		System.out.println("addANodeToHead " + str);
		list.addANodeToHead(str);
		list.printList("List -> ");

		str = "segunda";
		System.out.println("addANodeToHead " + str);
		list.addANodeToHead(str);
		list.printList("List -> ");

		System.out.println("IndexOf Quatro -> " + list.IndexOf("quatro"));
		System.out.println("IndexOf cinco -> " + list.IndexOf("cinco"));
		System.out.println("IndexOf segunda -> " + list.IndexOf("segunda"));

		System.out.println("removeElement Quatro -> "
				+ list.removeElement("quatro"));
		list.printList("List -> ");
		System.out.println("removeElement cinco -> "
				+ list.removeElement("cinco"));
		list.printList("List -> ");
		System.out.println("removeElement segunda -> "
				+ list.removeElement("segunda"));
		list.printList("List -> ");

	}
}