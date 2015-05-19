package classcode.p09EnumeradosENestedClasses;

public class C02EnumWithState {

	public static void main(String[] args) {

		// values
		TShirt[] tshirts = TShirt.values();
		System.out.println("Listagem das tshirts:");
		for (int i = 0; i < tshirts.length; i++) {
			System.out.println("tshirt[" + i + "] -> ");
		}

		TShirt t0 = TShirt.L;
		System.out.println("\nt0 -> " + t0);
		System.out.println("\nt0 price -> " + t0.getPrice());

	}
}

enum TShirt {
	S(5.0f), M(6.0f), L(6.5f), XL(8.0f);

	private float price;

	private TShirt(float price) {
		this.price = price;
	}

	public String toString() {
		// super.toString obt�m o nome do valor
		return super.toString() + ", " + price;
	}
	
	public float getPrice() {
		return price;
	}
}