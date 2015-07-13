package tps.tp4;

import java.awt.Color;

public class LigacaoRectaVertical extends LigacaoRecta {
	private static final long serialVersionUID = 1L;
	private String nome;

	public LigacaoRectaVertical(Color cor) {
		super(cor);
		this.nome = "LigacaoRectaVertical";
	}
	
	public String getNome(){
		return nome;
	}

}
