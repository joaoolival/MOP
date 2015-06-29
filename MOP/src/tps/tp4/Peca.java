package tps.tp4;
import java.awt.Color;
import java.awt.Graphics;

public class Peca extends Elemento {
	private static final long serialVersionUID = -8277228317521251913L;
    private String nome;
	
	public Peca(Color cor){
		super(cor);
		this.nome = "Peca";
	}
	
	public String getNome(){
		return nome;
	}
	
	/*@Override
    public void paintComponent(Graphics g) {
        g.setColor(cor);
        g.fillOval(40, 40, 100, 100);
    }*/
}
