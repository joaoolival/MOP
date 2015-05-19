package classcode.p12Generics;

/**
 * Classe para testes avulsos
 */

public class C10Test<T> {
	T u;

	private C10Test(T u) {
		this.u = u;
	}

	T m1(T x) {
		T old = u;
		u = x;
		return old;
	}

	T get() {
		return u;
	}

	public static void main(String[] args) {

		C10Test<String> o1 = new C10Test<String>("olá");
		System.out.println(o1.m1("bom"));
		System.out.println(o1.m1("dia"));
		// C10Test<Integer> o3 = o1;

		C10Test<Integer> o4 = new C10Test<Integer>(10);
		System.out.println("o4.get() -> " + o4.get());

		C10Test<Cat> myCat = new C10Test<Cat>(new Cat());
		System.out.println("myCat -> " + myCat);

		// C10Test<Long> o5 = new C10Test<Integer>(10);

		C10Test<C10Test<String>> o2 = new C10Test<C10Test<String>>(o1);
		// C10Test<String> r = o2.m1(new C10Test<String>("xx"));
		// System.out.println(r.get());
		System.out.println(o2.get());
	}

}

class Cat {

}
