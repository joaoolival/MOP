package tps.tp4;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Tabuleiro extends JPanel {
	private static final long serialVersionUID = -2644847326361294863L;
	private Quadricula[][] quadriculas;
	
	public Tabuleiro(Quadricula[][] quadriculas, int nRows, int nCols) {
		
		GridLayout gl1 = new GridLayout(nRows, nCols);
		setLayout(gl1);
		gl1.setVgap(2);
		gl1.setHgap(2);
		
		if (quadriculas.length == nRows && quadriculas[0].length == nCols) {
			this.quadriculas = quadriculas;
			setQuad();
			setOpaque(true);
		}	
	}
	
	private void setQuad(){
		for (int i = 0; i < quadriculas.length; i++) {
			for (int j = 0; j < quadriculas.length; j++) {
				add(quadriculas[i][j].getElemento());
			}
		}
	}
	
	public void setElemento(int x,int y, Elemento elemento){
		quadriculas[y][x].setElemento(elemento); 
		repaint();
	}
	
	public Quadricula[][] getGrids(){
		return quadriculas;
	}
}
