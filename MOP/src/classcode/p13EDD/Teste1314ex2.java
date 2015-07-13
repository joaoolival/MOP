package classcode.p13EDD;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Teste1314ex2 {
	
	public static void printIterable(Iterable<String> container) {
		Iterator<String> it = container.iterator();
		System.out.print("[");
		while (it.hasNext()) {
			System.out.print(it.next());
			if (it.hasNext())
				System.out.print(", ");
		}
		System.out.println("]");
	}
	
	public static void remove(ListIterator<Integer> container){
		int aux1 = container.next();
		while(container.hasNext()){
			int aux2 = container.next();
			if(aux1==aux2){
				container.remove();
			}
			else{
				aux1=aux2;
			}
		}
	}
	
	public static void tests(Integer i, ListIterator<Integer> container){
		while(container.hasNext()){
			int aux = container.next();
			if(i<=aux){
				container.previous();
				container.add(i);
				break;
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(6);
		l.add(7);

		System.out.println(l);
		ListIterator<Integer> litr = l.listIterator();
		tests(5,litr);
		System.out.println(l);
		
	}

}
