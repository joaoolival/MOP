package tps.tp4;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class main {

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
				// creating and showing this application's GUI.
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						handler();
					}
				});
				System.out.println("End of main...");
	}
	
	public static void handler(){
		JFrame frame = new JFrame();
		frame.setTitle("ConnectAll - by Joao Olival");
		frame.setSize(600, 600);
		// to center a frame
		frame.setLocationRelativeTo(null);
		// set default close operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		//GridLayout gl = new GridLayout(1, 1, 5, 5);
		//frame.setLayout(gl);
		
		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		// life goes on
		System.out.println("Frame created...");
		TabuleiroDim5 test = new TabuleiroDim5();
		frame.add(test.panel);
		
	}
	

}
