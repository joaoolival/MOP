package tps.tp4;

import java.awt.Color;

import javax.swing.JLabel;

public abstract class Elemento extends JLabel {
	private static final long serialVersionUID = -3509712629827253893L;
	static final Color BACKGROUNDCOLOR = new Color(100, 100, 100);
	
	protected Color cor;

	public Elemento(Color cor) {
		this.cor = cor;
		setOpaque(true);
		setBackground(BACKGROUNDCOLOR);
		//setText("enter text here");
		//setForeground (Color.red);

	}
	
	protected abstract String getNome();
	
	/*@Override
	protected abstract void paintComponent(Graphics g);*/

}
