package tps.tp4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;



public class Quadricula extends JLabel {
	static final Color BACKGROUNDCOLOR = new Color(100, 100, 100);
	
	private int x;
	private int y;
	private MouseListener listener;

	Quadricula(int x, int y) {
		this.x = x;
		this.y = y;
		this.listener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// if right mouse button: rotate ship
				if (e.getButton() == MouseEvent.BUTTON3) {
					System.out.println("right");
				}
				// if left mouse button: put ship on board
				if (e.getButton() == MouseEvent.BUTTON1) {
					System.out.println("left" + x + y);

				}
			}
		};
		setOpaque(true);
		setBackground(BACKGROUNDCOLOR);
		//desenhar oval
		addMouseListener(this.listener);
	}

	int getTabX() {
		return x;
	}

	int getTabY() {
		return y;
	}
	


}


