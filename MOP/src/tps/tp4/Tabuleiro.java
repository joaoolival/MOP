package tps.tp4;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class Tabuleiro<E> extends JPanel {

	private E[][] grids;
	
	//grids vai ser array de quadriculas
	Tabuleiro(E[][] grids, int nRows, int nCols) {
		GridLayout gl1 = new GridLayout(nRows, nCols);
		setLayout(gl1);
		gl1.setVgap(2);
		gl1.setHgap(2);

		if (grids.length == nRows && grids[0].length == nCols) {
			this.grids = grids;
		}
	}
	
	void setQuad(E quad,int posX,int posY){
		this.grids[posY][posX] = quad;
	}
	
	E[][] getGrids(){
		return this.grids;
	}
}
