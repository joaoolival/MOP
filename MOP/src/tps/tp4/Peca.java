package tps.tp4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import tps.tp4.Elemento.Colors;

public class Peca extends Elemento {
	private static final long serialVersionUID = -8277228317521251913L;
	private String nome;
	private Colors[] colors;

	public Peca(Quadricula quadricula, Color cor) {
		super(cor);
		this.nome = "Peca";
		this.colors = Colors.values();
		
		

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					System.out.println("right");

				}
				if (e.getButton() == MouseEvent.BUTTON1) {
					// System.out.println("left");
					quadricula.setElemento(new ElementoVazio(quadricula));

				}
			}
		});
		
		
	}

	public String getNome() {
		return nome;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(cor);
		g.fillOval(0, 0, getWidth(), getHeight());
		g.setColor(new Color(colors[2].getRedValue(),colors[2].getGreenValue(),colors[2].getBlueValue()));
		g.fillOval(25, 25, getWidth() - 50, getHeight() - 50);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospace", Font.BOLD, getHeight()/2+getHeight()/5));
		g.drawString("1", getWidth()/2-getHeight()/6, getHeight()/2+getHeight()/4);
	}
}
