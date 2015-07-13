package tps.tp4;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Tabuleiro extends JPanel {
	private static final long serialVersionUID = -2644847326361294863L;
	private Quadricula[][] quadriculas;
	
	public Tabuleiro(int nRows, int nCols) {
		
		GridLayout gl1 = new GridLayout(nRows, nCols);
		setLayout(gl1);
		gl1.setVgap(2);
		gl1.setHgap(2);
		
		Quadricula[][] quadriculas = new Quadricula[5][5];
		for (int i = 0; i < quadriculas.length; i++) {
			for (int j = 0; j < quadriculas.length; j++) {
				quadriculas[i][j] = new Quadricula(i, j,this);
			}
		}
		this.quadriculas = quadriculas;
		setQuad();
		setBackground(Color.yellow);
		
	}
	
	public void setQuad(){
		for (int i = 0; i < quadriculas.length; i++) {
			for (int j = 0; j < quadriculas.length; j++) {
				add(quadriculas[i][j].getElemento());
			}
		}
	}
	
	public Quadricula getQuadricula(int x, int y){
		return quadriculas[x][y];
	}
	
	public void setElemento(int x,int y, Elemento elemento){
		quadriculas[y][x].setElemento(elemento);
		
	}
	
	public Quadricula[][] getGrids(){
		return quadriculas;
	}
}
