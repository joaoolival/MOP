package tps.tp4;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Jogo extends JFrame {
	private static final long serialVersionUID = -6389135636258189807L;
	private Tabuleiro tabuleiro;

	//public Jogo() {
	//	init();
	//}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				init();
				//new Jogo();
			}
		});
		System.out.println("End of main...");
	}

	public static void init() {
		JFrame frame  = new JFrame();

		frame.setTitle("ConnectAll - by Joao Olival");
		frame.setSize(600, 600);
		// to center a frame
		frame.setLocationRelativeTo(null);
		// set default close operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// GridLayout gl = new GridLayout(1, 1, 5, 5);
		// frame.setLayout(gl);
		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		// life goes on
		System.out.println("Frame created...");
		
		//frame.initTabuleiro();
		
		JPanel test = new JPanel();
		test.setOpaque(true);
		test.setBackground(new Color(0x2DD0D0));
		frame.add(test);

	}

	private void initTabuleiro() {
		Quadricula[][] quad = new Quadricula[5][5];
		for (int i = 0; i < quad.length; i++) {
			for (int j = 0; j < quad.length; j++) {
				quad[i][j] = new Quadricula(i, j);
			}
		}
		this.tabuleiro = new TabuleiroDim5(quad);
		add(this.tabuleiro);
		
		Peca peca1 = new Peca(Color.BLUE);
		
		this.tabuleiro.setElemento(4, 2, peca1);
	}

}
