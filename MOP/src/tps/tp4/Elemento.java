package tps.tp4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public abstract class Elemento extends JLabel {
	private static final long serialVersionUID = -3509712629827253893L;
	static final Color BACKGROUNDCOLOR = new Color(100, 100, 100);
	
	protected Color cor;

	public Elemento(Color cor) {
		this.cor = cor;
		setBackground(BACKGROUNDCOLOR);
		setOpaque(true);
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					System.out.println("right");
				}
				// if left mouse button: put ship on board
				if (e.getButton() == MouseEvent.BUTTON1) {
					System.out.println("left");

				}
			}
		});

	}
	
	@Override
	protected abstract void paintComponent(Graphics g);

}
