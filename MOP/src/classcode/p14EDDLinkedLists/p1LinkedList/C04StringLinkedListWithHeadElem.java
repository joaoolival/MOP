package classcode.p14EDDLinkedLists.p1LinkedList;

/**
 * Lista com elemento sentinela
 * 
 * 
 */
public class C04StringLinkedListWithHeadElem {
	protected Node head;

	public C04StringLinkedListWithHeadElem() {
		// TODO
	}

	/**
	 * Adds a node at the start of the list. The added node has addData as its
	 * data. The added node will be the first node in the list.
	 */
	public void addANodeToHead(String addData) {
		// TODO
	}

	/**
	 * Deletes head node
	 * 
	 */
	public String deleteHeadNode() {
		// TODO
		return null;
	}

	/**
	 * Adds a node at the tail of the list. The added node has addData as its
	 * data. The added node will be the last node in the list.
	 */
	public void addANodeToTail(String addData) {
		// TODO
	}

	/**
	 * Deletes tail node
	 * 
	 */
	public String deleteTailNode() {
		// TODO
		return null;
	}

	/**
	 * Shows the list
	 */
	public void showList() {
		// TODO
	}

	public String getElementAt(int pos) {
		// TODO
		return null;
	}

	public boolean insertAt(String str, int pos) {
		// TODO
		return false;
	}

	public String removeAt(int pos) {
		// TODO
		return null;
	}

	/**
	 * Devolver o index da primeira string igual ao argumento passado Devolve -1
	 * caso n�o encontre
	 */
	public int IndexOf(String str) {
		// TODO
		return -1;
	}

	// remove e devolve a primeira ocorr�ncia do argumento recebido
	// caso n�o encontre devolve null
	public String removeElement(String str) {
		// TODO
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
		C04StringLinkedListWithHeadElem list = new C04StringLinkedListWithHeadElem();

		list.addANodeToHead("One");
		list.addANodeToHead("Two");
		list.addANodeToHead("Three");
		list.showList();
		System.out.println();

		System.out.println("deleteHeadNode  -> " + list.deleteHeadNode());
		list.printList("List -> ");
		System.out.println("deleteHeadNode  -> " + list.deleteHeadNode());
		list.printList("List -> ");
		System.out.println("deleteHeadNode  -> " + list.deleteHeadNode());
		list.printList("List -> ");
		System.out.println("deleteHeadNode  -> " + list.deleteHeadNode());
		list.printList("List -> ");

		String str = "sete";
		System.out.println("addANodeToTail " + str);
		list.addANodeToTail(str);
		list.printList("List -> ");

		str = "segunda";
		System.out.println("addANodeToTail " + str);
		list.addANodeToTail(str);
		list.printList("List -> ");

		System.out.println("deleteTailNode  -> " + list.deleteTailNode());
		list.printList("List -> ");
		System.out.println("deleteTailNode  -> " + list.deleteTailNode());
		list.printList("List -> ");
		System.out.println("deleteHeadNode  -> " + list.deleteTailNode());
		list.printList("List -> ");

		list.addANodeToHead("One");
		list.addANodeToHead("Two");
		list.addANodeToHead("Three");
		list.printList("List -> ");
		System.out.println("Element at 0 -> " + list.getElementAt(0));
		System.out.println("Element at 1 -> " + list.getElementAt(1));
		System.out.println("Element at 2 -> " + list.getElementAt(2));
		System.out.println("Element at 3 -> " + list.getElementAt(3));
		//

		System.out.println("InsertAt test====================");
		str = "um";
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
		//
		// str = "quatro";
		// pos = 0;
		// System.out.println("InsertAt " + str + " at " + pos + " -> "
		// + list.insertAt(str, pos));
		// list.printList("List -> ");
		//
		// System.out.println("addANodeToHead " + str);
		// list.addANodeToHead(str);
		// list.printList("List -> ");
		//
		// str = "segunda";
		// System.out.println("addANodeToHead " + str);
		// list.addANodeToHead(str);
		// list.printList("List -> ");
		//
		// System.out.println("IndexOf Quatro -> " + list.IndexOf("quatro"));
		// System.out.println("IndexOf cinco -> " + list.IndexOf("cinco"));
		// System.out.println("IndexOf segunda -> " + list.IndexOf("segunda"));
		//
		// System.out.println("removeElement Quatro -> "
		// + list.removeElement("quatro"));
		// list.printList("List -> ");
		// System.out.println("removeElement cinco -> "
		// + list.removeElement("cinco"));
		// list.printList("List -> ");
		// System.out.println("removeElement segunda -> "
		// + list.removeElement("segunda"));
		// list.printList("List -> ");

	}
}

// public String getElementAt(int pos) {
// Node currElem = head;
// for (int i = 0; i < pos; i++) {
// if (currElem == null)
// return null;
// currElem = currElem.link;
// }
// return currElem != null ? currElem.data : null;
// }
//
// public boolean insertAt(String str, int pos) {
// if (pos < 0)
// throw new IllegalArgumentException("index negativo");
// if (pos == 0) {
// head = new Node(str, head);
// return true;
// }
// Node currElem = head;
// for (int i = 0; i < pos - 1; i++) {
// if (currElem == null)
// return false;
// currElem = currElem.link;
// }
// currElem.link = new Node(str, currElem.link);
// return true;
// }
//
// public String removeAt(int pos) {
// if (pos < 0)
// throw new IllegalArgumentException("index negativo");
// // remo��o � cabe�a
// if (pos == 0) {
// if (head == null)
// return null;
// String data = head.data;
// head = head.link;
// return data;
// }
// // remo��o no meio ou no fim da lista
// Node currElem = head;
// for (int i = 0; i < pos - 1; i++) {
// if (currElem == null)
// return null;
// currElem = currElem.link;
// }
// String data = currElem.link.data;
// currElem.link = currElem.link.link;
// return data;
// }

