package tps.tp4;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import tps.tp4.Elemento.Colors;

public class ElementoVazio extends Elemento {
	private static final long serialVersionUID = 5911365035416195247L;
	private String nome;
	private Quadricula quadricula;
	
	private Colors[] colors;

	public ElementoVazio(Quadricula quadricula) {
		super(Color.GRAY);
		this.nome = "Vazio";
		this.quadricula = quadricula;
		this.colors = Colors.values();
		
		
		addMouseListener(new MouseAdapter() {
			int c = 0;
			public void mouseClicked(MouseEvent e) {
				
				if (e.getButton() == MouseEvent.BUTTON3) {
					System.out.println("right");

				}
				if (e.getButton() == MouseEvent.BUTTON1) {
					// System.out.println("left");
					// tem de ser assim porque elemento e que ve o clique
					//conta numero de clicks
					quadricula.setElemento(new Peca(quadricula, new Color(colors[e.getClickCount()].getRedValue(),colors[e.getClickCount()].getGreenValue(),colors[e.getClickCount()].getBlueValue())));
					
					c++;
					if(c > 20){
						c = 0;
					}

				}
			}
		});
	}

	public String getNome() {
		return nome;
	}

	/*
	 * @Override public void paintComponent(Graphics g) {
	 * g.setColor(Color.BLUE); g.fillOval(20, 20, 20, 20); }
	 */
}
