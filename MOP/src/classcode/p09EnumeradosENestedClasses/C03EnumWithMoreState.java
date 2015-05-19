package classcode.p09EnumeradosENestedClasses;

public class C03EnumWithMoreState {

	public static void main(String[] args) {

		// values
		TShirt2[] tshirts = TShirt2.values();
		System.out.println("Listagem das tshirts:");
		for (int i = 0; i < tshirts.length; i++) {
			System.out.println("tshirt[" + i + "] -> " + tshirts[i]);
		}
	}
}

enum TShirt2 {
	S(5.0f) {
		// defini��o dos m�todos abstractos
		String getComment() {
			return "too small";
		}
	},
	M(6.0f) {
//		int x = 0;

		String getComment() {
//			m1();
			return "small";
		}

		// private void m1() {
		// // ...
		// }
	},
	L(6.5f) {
		String getComment() {
			return "large";
		}
	},
	XL(8.0f) {
		String getComment() {
			return "too large";
		}
	};

	private float price;

	private TShirt2(float price) {
		this.price = price;
	}

	public String toString() {
		return super.toString() + ", " + price + ", " + getComment();
	}

	// m�todo abstracto
	abstract String getComment();
}