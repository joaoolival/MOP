package tps.tp4;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JLabel;
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
			//setOpaque(true);
			setBackground(Color.yellow);
			//setBorder(new LineBorder(Color.orange, 15));
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
		removeAll(); 
		// refresh the panel.
		updateUI();
		setQuad();
		//add(quadriculas[y][x].getElemento(),x*y);
		//quadriculas[y][x].getElemento().setVisible(true);
		//revalidate();
		//repaint();
	}
	
	public Quadricula[][] getGrids(){
		return quadriculas;
	}
}
