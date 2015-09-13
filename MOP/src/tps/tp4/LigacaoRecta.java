package tps.tp4;

import java.awt.Color;

public abstract class LigacaoRecta extends Ligacao {

	private static final long serialVersionUID = -4525304453685992769L;

	public LigacaoRecta(Color cor, Quadricula quadricula) {
		super(cor, quadricula);
	}

	public abstract String getNome();

}
