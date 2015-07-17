package tps.tp4;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Tabuleiro extends JPanel {
	private static final long serialVersionUID = -2644847326361294863L;
	private Quadricula[][] quadriculas;
	private Trajecto trajecto;
	
	public Tabuleiro(int nRows, int nCols) {
		
		GridLayout gl1 = new GridLayout(nRows, nCols);
		setLayout(gl1);
		gl1.setVgap(2);
		gl1.setHgap(2);
		
		Quadricula[][] quadriculas = new Quadricula[nRows][nCols];
		for (int i = 0; i < quadriculas.length; i++) {
			for (int j = 0; j < quadriculas.length; j++) {
				quadriculas[i][j] = new Quadricula(this,j, i);
			}
		}
		this.quadriculas = quadriculas;
		setQuad();
		setBackground(Color.yellow);
		this.trajecto = new Trajecto(this);
	}
	
	public Trajecto getTrajecto(){
		return trajecto;
	}
	
	public void setTrajecto(Trajecto trajecto){
		;
	}
	
	
	
	public void setQuad(){
		for (int i = 0; i < quadriculas.length; i++) {
			for (int j = 0; j < quadriculas.length; j++) {
				add(quadriculas[i][j].getElemento());
			}
		}
	}
	
	public Quadricula getQuadricula(int x, int y){
		return quadriculas[y][x];
	}
	
	public void setElemento(int x,int y, Elemento elemento){
		quadriculas[y][x].setElemento(elemento);
	}
	
	public Quadricula[][] getGrids(){
		return quadriculas;
	}
}
