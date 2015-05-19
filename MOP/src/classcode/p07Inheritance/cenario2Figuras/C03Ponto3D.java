package classcode.p07Inheritance.cenario2Figuras;


/**
 * Class Ponto3D - suporta um ponto num espa�o a tr�s dimens�es
 * 
 */
public class C03Ponto3D extends C02Ponto2D {

	int z;

	//
	// ## M�todos ## ----------------------

	public C03Ponto3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public String getDescricao() {
		return super.getDescricao() + ", z -> " + getZ();
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		C03Ponto3D p1 = new C03Ponto3D(3, 5, 7);
		System.out.println(p1);
		System.out.println();

		// utiliza��o dos m�todos getX e setX definidos na classe base de todas
		p1.setX(p1.getX() * 2);
		System.out.println("x = x * 2 ->  " + p1);
		
		// utiliza��o dos m�todos getY e setY definidos na classe super
		p1.setY(p1.getY() * 2);
		System.out.println("y = y * 2 ->  " + p1);
		
		p1.setZ(p1.getZ() * 2);
		System.out.println("z = z * 2 ->  " + p1);

	}
}
