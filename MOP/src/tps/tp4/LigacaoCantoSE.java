package tps.tp4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class LigacaoCantoSE extends LigacaoCanto {
	private static final long serialVersionUID = -6879660921103970248L;
	private String nome;

	public LigacaoCantoSE(Quadricula quadricula, Color cor) {
		super(cor, quadricula);
		this.nome = "LigacaoCantoSE";
	}

	public String getNome() {
		return nome;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(getCor());
		g.fillRect(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight()
				- (getHeight() / 4));
		g.fillRect(getWidth() - (getWidth() / 2), getHeight() / 4,
				getWidth() / 2, getHeight() / 2 + 1);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospace", Font.BOLD, 20));
		g.drawString(
				Integer.toString(quadricula.getTabY()) + " , "
						+ Integer.toString(quadricula.getTabX()),
				getWidth() / 2, getHeight() / 2);
	}
}
