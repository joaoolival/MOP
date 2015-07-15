package tps.tp4;

import java.awt.Color;

public abstract class Ligacao extends Elemento{
	private static final long serialVersionUID = 6097353594392208410L;

	public Ligacao(Color cor, Quadricula quadricula) {
		super(cor,quadricula);
	}
	
	public abstract String getNome();
	

}
