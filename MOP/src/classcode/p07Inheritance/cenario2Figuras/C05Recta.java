package classcode.p07Inheritance.cenario2Figuras;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class Recta - suporta uma recta
 * 
 */
class C05Recta extends C04Figura {

	public C05Recta(C02Ponto2D p1, C02Ponto2D p2, Color color) {
		super(new C02Ponto2D[] { p1, p2 }, color);
	}

	public String getNome() {
		return "recta";
	}

	public double getArea() {
		return 0;
	}

	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.drawLine((int) pontos[0].getX(), (int) pontos[0].getY(),
				(int) pontos[1].getX(), (int) pontos[1].getY());
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		C05Recta r1 = new C05Recta(new C02Ponto2D(1, 1), new C02Ponto2D(2, 2),
				Color.blue);
		System.out.println("r1 -> " + r1);
	}

}