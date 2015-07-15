package tps.tp4;

import java.awt.Color;
import java.awt.Graphics;

public class LigacaoCantoNE extends LigacaoCanto {
	private static final long serialVersionUID = 7048709813327348818L;
	private String nome;

	public LigacaoCantoNE(Quadricula quadricula,Color cor) {
		super(cor,quadricula);
		this.nome = "LigacaoCantoNE";
	}
	
	public String getNome(){
		return nome;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(getCor());
		g.fillRect(getWidth()/4, 0, getWidth()/2, getHeight()-(getHeight()/4));
		g.fillRect(getWidth()-(getWidth()/2), getHeight()/4, getWidth()/2, getHeight()/2+1);
	}
}
