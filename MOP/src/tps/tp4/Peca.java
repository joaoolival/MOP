package tps.tp4;
import java.awt.Color;
import java.awt.Graphics;

public class Peca extends Elemento {
	private static final long serialVersionUID = -8277228317521251913L;
	
	public Peca(Color cor){
		super(cor);
	}
	
	@Override
    public void paintComponent(Graphics g) {
        g.setColor(cor);
        g.fillOval(100, 100, 100, 100);
    }
}
