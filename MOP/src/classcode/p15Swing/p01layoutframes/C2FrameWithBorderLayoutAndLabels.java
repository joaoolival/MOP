package classcode.p15Swing.p01layoutframes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Demonstra a utiliza��o de JLabel e BorderLayout.
 * 
 * Uma JFrame tem o BorderLayout com LayoutManager por omiss�o.
 * 
 * Assuntos: BorderLayout, JLabels, setBackground
 * 
 * Um BorderLayout disp�e os elementos pela orienta��o centro(center), norte
 * (NORTH ou PAGE_START), sul (SOUTH ou PAGE_END), oeste (WEST ou LINE_START) e
 * este (EAST ou LINE_END). O componente que fica no centro ocupar� todo o
 * espa�o que puder, as restantes posi��es ocupam somente o necess�rio para
 * mostrar o componente.
 * 
 * BorderLayout.NORTH, SOUTH,..., PAGE_START, PAGE_END, ...
 * 
 * 
 * @author Ant�nio Te�filo
 * 
 */

public class C2FrameWithBorderLayoutAndLabels {

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

	public static void createAndShowGUI() {
		// create a JFrame
		JFrame frame = new JFrame();
		// set title
		frame.setTitle("...: My Border Layout frame :...");
		// set size
		frame.setSize(400, 200);
		// set location
		frame.setLocationRelativeTo(null); // to center a frame
		// set Default Close Operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		BorderLayout bl = new BorderLayout(5, 2);
		// 5 is horizontalGap, 1 is verticalGap
		// colocar o BorderLayout no contentPane da frame
		frame.getContentPane().setLayout(bl);
		// frame.setLayout(bl);

		// criar uma JLabel dar-lhe c�r e coloc�-la no in�cio da linha
		JLabel labelStart = new JLabel("LabelStart");
		labelStart.setOpaque(true);
		labelStart.setBackground(new Color(0, 0, 250));
		// das linhas seguintes s� activar uma
		// frame.getContentPane().add(labelStart, BorderLayout.LINE_START);
		// frame.add(labelStart, BorderLayout.LINE_START);
		frame.getContentPane().add(labelStart, BorderLayout.WEST);

		// criar uma JLabel dar-lhe c�r e coloc�-la no topo da p�gina
		JLabel labelTop = new JLabel("LabelTop");
		labelTop.setOpaque(true);
		labelTop.setBackground(new Color(140, 0, 0));
		labelTop.setHorizontalAlignment(SwingConstants.CENTER);
		// das linhas seguintes s� activar uma, pois s�o equivalentes
		// frame.add(labelTop, BorderLayout.PAGE_START);
		frame.getContentPane().add(labelTop, BorderLayout.NORTH);

		// criar uma JLabel dar-lhe alguma c�r e coloc�-la no centro
		JLabel labelCenter = new JLabel("LabelCenter");
		labelCenter.setOpaque(true);
		labelCenter.setBackground(new Color(0, 140, 0));
		labelCenter.setHorizontalAlignment(SwingConstants.CENTER);
		labelCenter.setToolTipText("    Label Center    ");
		// colocar esta label no centro
		frame.getContentPane().add(labelCenter, BorderLayout.CENTER);

		// criar uma JLabel dar-lhe c�r e coloc�-la no topo da p�gina
		JLabel labelBottom = new JLabel("LabelBottom");
		labelBottom.setOpaque(true);
		labelBottom.setBackground(new Color(0, 200, 50));
		labelBottom.setHorizontalAlignment(SwingConstants.CENTER);
		// das linhas seguintes s� activar uma, pois s�o equivalentes
		// frame.getContentPane().add(labelBottom, BorderLayout.PAGE_END);
		frame.getContentPane().add(labelBottom, BorderLayout.SOUTH);

		// criar uma JLabel dar-lhe c�r e coloc�-la no lado dir da p�gina
		JLabel labelBottom2 = new JLabel("- - - - - ");
		labelBottom2.setOpaque(true);
		labelBottom2.setBackground(new Color(100, 200, 150));
		// das linhas seguintes s� activar uma, pois s�o equivalentes
		frame.getContentPane().add(labelBottom2, BorderLayout.EAST);

		// alterar a cor de fundo do contentPane
		// frame.getContentPane().setBackground(Color.yellow);

		// definnir uma dimens�o m�nima
		frame.setMinimumSize(new Dimension(300, 300));

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);

		// life goes on
		System.out.println("Frame created...");
	}
}
