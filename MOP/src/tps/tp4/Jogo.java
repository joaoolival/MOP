package tps.tp4;

import java.awt.Dimension;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Jogo extends JFrame {
	private static final long serialVersionUID = -6389135636258189807L;
	//private Tabuleiro tabuleiro;

	//public Jogo() {
	//	init();
	//}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					init();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//new Jogo();
			}
		});
		System.out.println("End of main...");
	}

	public static void init() throws FileNotFoundException {
		JFrame frame  = new JFrame();
		frame.setTitle("ConnectAll - by Joao Olival");
		frame.setSize(800, 800);
		// to center a frame
		frame.setLocationRelativeTo(null);
		// set default close operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// GridLayout gl = new GridLayout(1, 1, 5, 5);
		// frame.setLayout(gl);
		// life goes on
		System.out.println("Frame created...");
		
		Tabuleiro test = initTabuleiro();
		/*for (int i = 0; i < test.getGrids().length; i++) {
			for (int j = 0; j < test.getGrids()[0].length; j++){
				System.out.println( test.getGrids()[i][j].getElemento().getNome());
			}
		}*/
		frame.add(test);
	
		frame.setMinimumSize(new Dimension(400, 400));
		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
	}

	private static Tabuleiro initTabuleiro() throws FileNotFoundException {
		
		Tabuleiro tabuleiro = new TabuleiroDim5();
		
		//Peca peca1 = new Peca(tabuleiro.getQuadricula(0, 0), Color.RED);
		//tabuleiro.setElemento(0, 0, peca1);
		
		return tabuleiro;
	}

}
