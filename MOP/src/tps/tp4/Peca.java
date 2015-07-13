package tps.tp4;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Peca extends Elemento {
	private static final long serialVersionUID = -8277228317521251913L;
    private String nome;
	
	public Peca(Quadricula quadricula, Color cor){
		super(cor);
		this.nome = "Peca";
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					System.out.println("right");
						
				}
				if (e.getButton() == MouseEvent.BUTTON1) {
					//System.out.println("left");
					quadricula.setElemento(new ElementoVazio(quadricula));

				}
			}
		});
	}
	
	public String getNome(){
		return nome;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(cor);
		g.fillOval(0,0,getWidth(),getHeight());
		g.setColor(Color.BLACK);
		g.fillOval(25,25,getWidth()-50,getHeight()-50);
	}
}
