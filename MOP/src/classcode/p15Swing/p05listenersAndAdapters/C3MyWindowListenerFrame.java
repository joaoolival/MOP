package classcode.p15Swing.p05listenersAndAdapters;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * WindowListener - permite receber os eventos associados � janela (window
 * events) quando � altera��o de estado. Os eventos s�o, window: opened,
 * closing, closed, activated or deactivated, iconified or deiconified.
 * 
 * Nota: existe o respectivo adapter: java.awt.event.WindowAdapter
 * 
 * Novidade: JOptionPane.showMessageDialog
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class C3MyWindowListenerFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	GridLayout gl = null;

	JLabel label1 = null;

	JButton button1 = null;

	private final Color leftColor = new Color(120, 240, 140);

	private final Color rightColor = new Color(120, 140, 240);

	private JPanel buttonsPanel;

	/**
	 * Este m�todo cria toda a frame e coloca-a vis�vel
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My Mouse Adapter frame :...");
		// set size
		setSize(400, 200);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //63

		ProportionalLayout cl = new ProportionalLayout(0.1f, 0.2f, 0.2f, 0.2f);
		setLayout(cl);

		// use of BorderLayout
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new CenterLayout());
		add(buttonsPanel, ProportionalLayout.SOUTH);

		// build JLabel
		label1 = new JLabel("See events in console...");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setOpaque(true);
		label1.setBackground(rightColor);
		add(label1, ProportionalLayout.CENTER);

		// button1
		button1 = new JButton("Ckick here!!!");
		button1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				System.out.print("Mouse clicked...");
				int b = e.getButton();
				switch (b) {
				case MouseEvent.BUTTON1:
					System.out.println(" left button...");
					label1.setBackground(leftColor);
					break;
				case MouseEvent.BUTTON3:
					System.out.println(" right button...");
					label1.setBackground(rightColor);
					// C5MyMouseListenerFrame.this.dispose();
					break;
				default:
					System.out.println(" center button...");
				}
			}

			// cool, we don't need to write the other methods :)
		});
		buttonsPanel.add(button1);

		WindowListener windowListener = new WindowListener() {
			int n = 0;

			public void windowActivated(WindowEvent e) {
				System.out.println(" windowActivated... in focus");
				// Invoked when the Window is set to be the active Window.
			}

			public void windowClosed(WindowEvent e) {
				System.out.println(" windowClosed...");
				// Invoked when a window has been closed as the result of
				// calling dispose on the window.
			}

			public void windowClosing(WindowEvent e) {
				System.out.println(" windowClosing...");
				// Invoked when the user attempts to close the window from the
				// window's system menu.

				if (++n == 3) {
					C3MyWindowListenerFrame.this.dispose(); // ou s� dispose();
					// e.getWindow().dispose(); //em alternativa
				} else {
					JOptionPane.showMessageDialog(null,
							"Frame will dispose at 3 - " + n, "Exit.",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			public void windowDeactivated(WindowEvent e) {
				System.out.println(" windowDeactivated... out of focus");
				// Invoked when a Window is no longer the active Window.
			}

			public void windowDeiconified(WindowEvent e) {
				System.out.println(" windowDeiconified...");
				// Invoked when a window is changed from a minimized to a normal
				// state.
			}

			public void windowIconified(WindowEvent e) {
				System.out.println(" windowIconified...");
				// Invoked when a window is changed from a normal to a minimized
				// state.
			}

			public void windowOpened(WindowEvent e) {
				System.out.println(" windowOpened...");
				// Invoked the first time a window is made visible.
			}

		};
		addWindowListener(windowListener);

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C3MyWindowListenerFrame myFrame = new C3MyWindowListenerFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
				System.out
						.println("Fa�am minimize � frame, restore e vejam os eventos gerados...");
			}
		});
		System.out.println("End of main...");
	}
}

// teste1: retirar o coment�rio da linha 63 e observar o novo funcionamento