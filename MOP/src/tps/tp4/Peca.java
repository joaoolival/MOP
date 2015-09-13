package tps.tp4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Peca extends Elemento {
	private static final long serialVersionUID = -8277228317521251913L;
	private String nome;
	private int numero;

	public Peca(Quadricula quadricula, Color cor, int numero) {
		super(cor, quadricula);
		this.nome = "Peca";
		this.numero = numero;

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					System.out.println("right");

				}
				if (e.getButton() == MouseEvent.BUTTON1) {
					// System.out.println("left");
					if (quadricula.setPeca(numero)) {
						aumentaNumero();
					}
					;

				}
			}
		});
	}

	public int getNumero() {
		return numero;
	}

	public void aumentaNumero() {
		numero++;
	}

	public String getNome() {
		return nome;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(getCor());
		g.fillOval(0, 0, getWidth(), getHeight());
		g.setColor(new Color(0, 0, 0));
		g.fillOval(25, 25, getWidth() - 50, getHeight() - 50);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospace", Font.BOLD, getHeight() / 2
				+ getHeight() / 5));
		g.drawString(Integer.toString(numero),
				getWidth() / 2 - getHeight() / 6, getHeight() / 2 + getHeight()
						/ 4);
	}
}
