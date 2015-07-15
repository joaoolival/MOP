package tps.tp4;

import java.awt.Color;
import java.awt.Graphics;

public class LigacaoCantoSE extends LigacaoCanto {
	private static final long serialVersionUID = -6879660921103970248L;
	private String nome;

	public LigacaoCantoSE(Quadricula quadricula,Color cor) {
		super(cor,quadricula);
		this.nome = "LigacaoCantoSE";
	}
	
	public String getNome(){
		return nome;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(getCor());
		g.fillRect(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()-(getHeight()/4));
		g.fillRect(getWidth()-(getWidth()/2), getHeight()/4, getWidth()/2, getHeight()/2+1);
	}
}

