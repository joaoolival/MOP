package classcode.p12Generics;

/**
 * Uma classe gen�rica com dois tipos gen�ricos e com um m�todo que delcara uma
 * argumento de outro tipo gen�rico
 */
public class C03Box3<T, U> {
	private T obj1;
	private U obj2;

	public C03Box3(T t, U u) {
		obj1 = t;
		obj2 = u;
	}

	public void set1(T t) {
		obj1 = t;
	}

	public void set2(U u) {
		obj2 = u;
	}

	public T get1() {
		return obj1;
	}

	public U get2() {
		return obj2;
	}

	/**
	 * M�todo que declara um tipo gen�rico que � utilizado dentro dele
	 */
	public <V> V inspect(V o) {
		System.out.println("T: " + obj1.getClass().getName());
		System.out.println("V: " + o.getClass().getName());
		return o;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		C03Box3<Integer, String> box = new C03Box3<Integer, String>(100, "Ol�");
		box.set1(30);
		System.out.println(box.get2() + " " + box.get1());

		// utiliza��o do m�todo que declara um tipo extra gen�rico

		// indica��o explicita do tipo
		// float f1 = box.<Float> inspect(new Float(3.9f));
		float f1 = box.<Float> inspect(3.9f);

		// indica��o implicita do tipo
		// String s =
		box.inspect(f1);

		// utiliza��o de outro tipo, recordar que o tipo s� � v�lido na chamada
		// ao m�todo, pelo que cada chamada pode utilziar um tipo diferente
		// String s =
		box.inspect("ol�");

		// situa��es incompat�veis
		// box.<Float> inspect(10); // ERRO
		// String s = box.inspect(f1);
	}
}
