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

public abstract class Tabuleiro {
	//private JFrame frame;
	//TEM DE SER PRIVATE
	JPanel panel;
	
	
	Tabuleiro(int nRows, int nCols){
		this.panel = new JPanel();
		
		GridLayout gl1 = new GridLayout(nRows, 1);
		this.panel.setLayout(gl1);
		
		JLabel[][] labels = new JLabel[nRows][nCols];
		// criar JLabels
		for (int y = 0; y < nRows; ++y) {
			for (int x = 0; x < nCols; ++x) {
				JLabel label = labels[y][x] = new JLabel("x: " + x + ", y:" + y);
				label.setBorder(new LineBorder(Color.red, 1));
				label.setOpaque(true);
				label.setBackground(new Color(0, 0,
						0));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				this.panel.add(label);
			}
		}

	}
	
	
	
	
	//public abstract void setGrid();

}
