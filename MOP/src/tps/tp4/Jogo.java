package tps.tp4;

import java.awt.Dimension;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Jogo extends JFrame {
	private static final long serialVersionUID = -6389135636258189807L;

	private JFrame frame;

	public Jogo() throws FileNotFoundException {
		this.frame = new JFrame();
		frame.setTitle("ConnectAll - by Joao Olival");
		frame.setSize(700, 700);

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		System.out.println("Frame created...");

		Menu menu = new Menu(this);

		frame.add(menu);
		frame.setMinimumSize(new Dimension(400, 400));
		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo jogo = new Jogo();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		System.out.println("End of main...");
	}

}
