package tps.tp4;
import java.awt.Color;
import java.awt.Graphics;

public class ElementoVazio extends Elemento {
	private static final long serialVersionUID = 5911365035416195247L;
	private String nome;

	public ElementoVazio(){
		super(Color.BLUE);
		this.nome = "Vazio";
	}
	
	public String getNome(){
		return nome;
	}
	
	/*@Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(20, 20, 20, 20);
    }*/
}

