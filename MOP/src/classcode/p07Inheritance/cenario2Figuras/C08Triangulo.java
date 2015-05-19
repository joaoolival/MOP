package classcode.p07Inheritance.cenario2Figuras;

import java.awt.Color;

/**
 * Class Triangulo - suporta um tri�ngulo
 * 
 */
class C08Triangulo extends C04Figura {

	double base, altura;

	/*
	 * Recebe os tr�s pontos mas tamb�m a base e a altura (para facilitar o
	 * c�lculo da �rea)
	 */
	public C08Triangulo(C02Ponto2D p1, C02Ponto2D p2, C02Ponto2D p3,
			double base, double altura, Color color) {
		super(new C02Ponto2D[] { p1.clone(), p2.clone(), p3.clone() }, color);

		this.base = base;
		this.altura = altura;
	}

	public String getNome() {
		return "tri�ngulo";
	}

	public double getArea() {
		return base * altura / 2;
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		C08Triangulo r1 = new C08Triangulo(new C02Ponto2D(1, 1),
				new C02Ponto2D(1, 6), new C02Ponto2D(5, 1), 5, 4, Color.red);
		System.out.println("r1 -> " + r1);
	}

}