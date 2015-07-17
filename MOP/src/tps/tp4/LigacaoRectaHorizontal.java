package tps.tp4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class LigacaoRectaHorizontal extends LigacaoRecta {
	private static final long serialVersionUID = -1063818420669798300L;
	private String nome;

	public LigacaoRectaHorizontal(Quadricula quadricula,Color cor) {
		super(cor,quadricula);
		this.nome = "LigacaoRectaVertical";
	}
	
	public String getNome(){
		return nome;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(getCor());
		g.fillRect(0, getWidth()/4, getWidth(), getHeight()/2);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospace", Font.BOLD, 20));
		g.drawString(Integer.toString(quadricula.getTabY()) + " , "+Integer.toString(quadricula.getTabX()) , getWidth()/2, getHeight()/2);
	}

}
