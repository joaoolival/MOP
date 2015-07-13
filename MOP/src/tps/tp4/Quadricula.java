package tps.tp4;

import java.awt.Color;





public class Quadricula {
	static final Color BACKGROUNDCOLOR = new Color(100, 100, 100);
	
	private int x;
	private int y;
	private Elemento elemento;
	private Tabuleiro tabuleiro;

	public Quadricula(int x, int y,Tabuleiro tabuleiro) {
		this.x = x;
		this.y = y;
		this.elemento = new ElementoVazio(this);
		this.tabuleiro = tabuleiro;
	}

	int getTabX() {
		return x;
	}

	int getTabY() {
		return y;
	}
	
	public Elemento getElemento(){
		return elemento;
	}
	
	public void setElemento(Elemento elemento){
		this.elemento = elemento;
		tabuleiro.removeAll(); 
		// refresh the panel.
		tabuleiro.updateUI();
		tabuleiro.setQuad();
		//add(quadriculas[y][x].getElemento(),x*y);
		//quadriculas[y][x].getElemento().setVisible(true);
		//revalidate();
		//repaint();
	}


}


