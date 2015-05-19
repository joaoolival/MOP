package classcode.p07Inheritance.cenario1Pontos;

/**
 * Class Ponto1D - suporta um ponto num espa�o a uma dimens�o
 * 
 */
public class Ponto1D {

	int x= 0;

	//
	// ## M�todos ## ----------------------

	public Ponto1D(int x) {
		this.x = x;
	}

	// public Ponto1D() {
	//
	// }

	public String getDescricao() {
		return "x -> " + x;
	}

	public String toString() {
		return "(" + getDescricao() + ")";
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		Ponto1D p1 = new Ponto1D(3);
		System.out.println(p1);
		System.out.println();

		p1.x = p1.x * 2;
		System.out.println(p1);
	}

}
