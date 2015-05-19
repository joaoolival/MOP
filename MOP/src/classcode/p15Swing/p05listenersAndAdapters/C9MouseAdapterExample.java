package classcode.p15Swing.p05listenersAndAdapters;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * MouseAdapter - este exemplo desloca um porta-avi�es do jogo da batalha naval
 * pelo painel central e permite rod�-lo com o bot�o direito do rato e coloc�-lo
 * com o bot�o esquerdo do rato.
 * 
 * Utiliza o ProportionalLayout
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class C9MouseAdapterExample extends JFrame {

	private static final long serialVersionUID = 1L;

	static final Color SHIPCOLOR = new Color(20, 220, 140);

	static final Color BACKGROUNDCOLOR = new Color(120, 140, 240);

	// enumerado com as quatro direc��es
	static enum Direction {
		UP, RIGHT, DOWN, LEFT
	};

	// array com as quatro direc��es
	static Direction[] dirValues = Direction.values();

	GridLayout gl = null;

	JButton bReset = null;

	private JPanel buttonsPanel;

	LineBorder border = new LineBorder(Color.orange, 2);

	private JPanel p;

	Direction direction = Direction.UP;

	/**
	 * Este m�todo cria toda a frame e coloca-a vis�vel
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My Mouse Listener frame :...");
		// set size
		setSize(400, 200);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		ProportionalLayout cl = new ProportionalLayout(0.1f, 0.2f, 0.1f, 0.1f);
		setLayout(cl);

		// use of BorderLayout
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new CenterLayout());
		add(buttonsPanel, ProportionalLayout.SOUTH);

		p = new JPanel(new GridLayout(10, 10, 1, 1));
		add(p, ProportionalLayout.CENTER);

		// button1
		bReset = new JButton("Reset board");
		bReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < p.getComponentCount(); i++) {
					((JLabel) p.getComponent(i)).setBackground(BACKGROUNDCOLOR);
				}
			}
		});
		buttonsPanel.add(bReset);

		MouseListener lml = new MouseAdapter() {

			public void mouseExited(MouseEvent e) {
				setBorder(e, null, direction, false);
			}

			public void mouseEntered(MouseEvent e) {
				setBorder(e, border, direction, false);
			}

			public void mouseClicked(MouseEvent e) {
				// if right mouse button: rotate ship
				if (e.getButton() == MouseEvent.BUTTON3) {
					setBorder(e, null, direction, false);
					// get the next direction +90�
					direction = dirValues[((direction.ordinal() + 1) % 4)];
					setBorder(e, border, direction, false);
				}
				// if left mouse button: put ship on board
				if (e.getButton() == MouseEvent.BUTTON1) {
					setBorder(e, border, direction, true);
				}
			}

			// draw or erase ship
			void setBorder(MouseEvent e, Border b, Direction direction,
					boolean fill) {
				int n = ((MyLabel) e.getSource()).n;
				setBorderAux(n, b, fill);
				setBorderAux(getN(n, 1, 0, direction), b, fill);
				setBorderAux(getN(n, -1, 0, direction), b, fill);
				setBorderAux(getN(n, 0, 1, direction), b, fill);
				setBorderAux(getN(n, 0, 2, direction), b, fill);
				// setBorderAux(getN(n, 1, 2, direction), b, fill);
			}

			void setBorderAux(int pos, Border b, boolean fill) {
				if (pos >= 0 && pos < p.getComponentCount()) {
					JLabel l = (JLabel) p.getComponent(pos);
					l.setBorder(b);
					if (fill)
						l.setBackground(SHIPCOLOR);
				}
			}
		};

		// create labels
		for (int i = 0; i < 100; i++) {
			JLabel l = new MyLabel(i);
			l.setOpaque(true);
			l.setBackground(BACKGROUNDCOLOR);
			l.addMouseListener(lml);
			p.add(l);
		}

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	private int getN(int n, int deltaX, int deltaY, Direction direction) {
		int aux = 0;
		switch (direction) {
		case DOWN:
			deltaY = -deltaY;
			deltaX = -deltaX;
			break;
		case RIGHT:
			aux = -deltaY;
			deltaY = deltaX;
			deltaX = aux;
			break;
		case LEFT:
			aux = deltaY;
			deltaY = -deltaX;
			deltaX = aux;
			break;
		case UP:
		}
		return n + deltaX + 10 * deltaY;
	}

	class MyLabel extends JLabel {
		private static final long serialVersionUID = 1L;
		int n;

		MyLabel(int n) {
			this.n = n;
		}
	}

	/**
	 * 
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C9MouseAdapterExample myFrame = new C9MouseAdapterExample();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}
