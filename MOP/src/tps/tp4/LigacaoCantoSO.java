package tps.tp4;

import java.awt.Color;
import java.awt.Graphics;

public class LigacaoCantoSO extends LigacaoCanto {
	private static final long serialVersionUID = -5218588913769087349L;
	private String nome;

	public LigacaoCantoSO(Quadricula quadricula,Color cor) {
		super(cor,quadricula);
		this.nome = "LigacaoCantoSO";
	}
	
	public String getNome(){
		return nome;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(getCor());
		g.fillRect(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()-(getHeight()/4));
		g.fillRect(0, getHeight()/4, getWidth()/2, getHeight()/2+1);
	}
}
