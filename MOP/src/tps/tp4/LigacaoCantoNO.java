package tps.tp4;

import java.awt.Color;
import java.awt.Graphics;

public class LigacaoCantoNO extends LigacaoCanto {
	private static final long serialVersionUID = -7417540762088726973L;
	private String nome;

	public LigacaoCantoNO(Quadricula quadricula,Color cor) {
		super(cor,quadricula);
		this.nome = "LigacaoCantoNO";
	}
	
	public String getNome(){
		return nome;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(getCor());
		g.fillRect(getWidth()/4, 0, getWidth()/2, getHeight()-(getHeight()/4));
		g.fillRect(0, getHeight()/4, getWidth()/2, getHeight()/2+1);
	}
}
