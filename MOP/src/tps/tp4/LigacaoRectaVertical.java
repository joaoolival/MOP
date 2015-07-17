package tps.tp4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class LigacaoRectaVertical extends LigacaoRecta {
	private static final long serialVersionUID = 1L;
	private String nome;

	public LigacaoRectaVertical(Quadricula quadricula,Color cor) {
		super(cor,quadricula);
		this.nome = "LigacaoRectaVertical";
	}
	
	public String getNome(){
		return nome;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(getCor());
		g.fillRect(getWidth()/4, 0, getWidth()/2, getHeight());
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospace", Font.BOLD, 20));
		g.drawString(Integer.toString(quadricula.getTabY()) + " , "+Integer.toString(quadricula.getTabX()) , getWidth()/2, getHeight()/2);
	}

}
