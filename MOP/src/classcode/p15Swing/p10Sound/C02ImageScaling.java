package classcode.p15Swing.p10Sound;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Novidades: scale an image, neste exemplo � utilizado o m�todo g2.drawImage
 * que permite desenhar num x,y e com um width,height, ou seja, faz o scaling em
 * cada draw.
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class C02ImageScaling extends JFrame {

	private static final long serialVersionUID = 1L;

	private MyPanel panelFish = null;

	private JButton buttonGrow = null;

	private JButton buttonShrink = null;

	JPanel panelControl = null;

	private final Color greenColor = new Color(0, 200, 0);

	private ImageIcon icon;

	private JToggleButton synchroTButton;

	/**
	 * Este m�todo cria toda a frame e coloca-a vis�vel
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My Image Scaling frame :...");
		// set size
		setSize(600, 400);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// add JLabel at center
		JPanel jpCenter = new JPanel();
		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.15f, 0.1f, 0.1f, 0.1f);
		jpCenter.setLayout(cl);

		// build JLabel
		panelFish = new MyPanel();
		panelFish.setOpaque(true);
		panelFish.setBackground(greenColor);

		jpCenter.add(panelFish);
		add(jpCenter, BorderLayout.CENTER);

		// Painel dos bot�es
		panelControl = new JPanel(); // Janel default layout -> FlowLayout
		TitledBorder tb = new TitledBorder("Control panel");
		tb.setTitleJustification(TitledBorder.CENTER);
		panelControl.setBorder(tb);

		synchroTButton = new JToggleButton("Synchro scaling");
		synchroTButton.setSelected(false);
		synchroTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGrow.setEnabled(!synchroTButton.isSelected());
				buttonShrink.setEnabled(!synchroTButton.isSelected());
				synchroScaleAction();
			}
		});
		panelControl.add(synchroTButton);

		// buttonStart
		buttonGrow = new JButton("Grow");
		buttonGrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				growActions();
			}
		});
		panelControl.add(buttonGrow);

		// buttonStop
		buttonShrink = new JButton("Shrink");
		buttonShrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shrinkActions();
			}
		});
		panelControl.add(buttonShrink);

		// adicionar o painel do bot�es � frame principal
		add(panelControl, BorderLayout.PAGE_END);

		icon = C01ImageManager.Images.PUFFERFISH.getImageIcon();
		panelFish.setIcon(icon);

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	private void synchroScaleAction() {
		panelFish.repaint();
	}

	private void growActions() {
		panelFish.grow();
		// panelFish.repaint();
	}

	private void shrinkActions() {
		panelFish.shrink();
		// panelFish.repaint();
	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C02ImageScaling myFrame = new C02ImageScaling();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}

	class MyPanel extends JPanel {
		private static final long serialVersionUID = 5033092942689338946L;

		int iconWidth = 0;
		int iconHeigth = 0;

		double scale = 0.7;

		Image image = null;

		public void setIcon(ImageIcon icon) {
			iconWidth = icon.getIconWidth();
			iconHeigth = icon.getIconHeight();
			image = icon.getImage();
		}

		public void shrink() {
			scale *= 0.8;
			System.out.println("new scale -> " + scale);
			repaint();
		}

		public void grow() {
			scale *= 1.2;
			System.out.println("new scale -> " + scale);
			repaint();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int width = getWidth();
			int height = getHeight();

			Graphics2D g2 = (Graphics2D) g;

			if (synchroTButton.isSelected()) {
				// synchro scaling
				g2.drawImage(image, (int) (width * 0.1f),
						(int) (height * 0.1f), (int) (width - width * 0.2f),
						(int) (height - height * 0.2f), null);
			} else {
				// scaling by buttons
				g2.drawImage(image, (int) ((width - iconWidth * scale) / 2),
						(int) ((height - iconHeigth * scale) / 2),
						(int) (iconWidth * scale), (int) (iconHeigth * scale),
						null);
			}
		}
	}
}
