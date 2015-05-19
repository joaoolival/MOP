package classcode.p15Swing.p01layoutframes;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 * Demonstra a utilização de GridLayout. Se nRows = 0 significa que pode ser
 * qualquer número de linhas. Se nCols = 0, significa que pode ser qualquer
 * número de colunas.
 * 
 * @author António Teófilo
 * 
 */

public class C3FrameWithGridLayout2 {

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
		System.out.println("End of main...");
	}

	/**
	 * Create and Show GUI
	 */
	public static void createAndShowGUI() {
		// create a JFrame
		JFrame frame = new JFrame();
		// set title
		frame.setTitle("...: My grid layout frame :...");
		// set size and location
		frame.setSize(400, 200);
		// to center a frame
		frame.setLocationRelativeTo(null);
		// set default close operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// build the gridLayout
		int nRows = 5; // 2; 4; 0;
		int nCols = 1; // 0; 2; 2;
		GridLayout gl = new GridLayout(nRows, nCols, 5, 5);
		frame.getContentPane().setLayout(gl);

		// set content pane background color
		frame.getContentPane().setBackground(new Color(0, 150, 200));

		Random rg = new Random();

		int nLabels = 6;

		// criar JLabels
		for (int x = 0; x < nLabels; ++x) {
			JLabel label = new JLabel(" " + x);
			label.setBorder(new LineBorder(Color.yellow, 1));
			label.setOpaque(true);
			label.setBackground(new Color(rg.nextInt(256), rg.nextInt(256), rg
					.nextInt(256)));
			frame.getContentPane().add(label);
			label.setHorizontalAlignment(SwingConstants.CENTER);

		}

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);

		// life goes on
		System.out.println("Frame created...");

	}
}
