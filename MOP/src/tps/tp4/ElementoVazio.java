package tps.tp4;
import java.awt.Color;
import java.awt.Graphics;

public class ElementoVazio extends Elemento {
	private static final long serialVersionUID = 5911365035416195247L;

	public ElementoVazio(){
		super(null);
	}
	
	@Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(100, 100, 100, 100);
    }
}

