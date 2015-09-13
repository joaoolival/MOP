package tps.tp4;

import java.awt.Color;

public abstract class LigacaoCanto extends Ligacao {
	private static final long serialVersionUID = -8582767480500366613L;

	public LigacaoCanto(Color cor, Quadricula quadricula) {
		super(cor, quadricula);
	}

	public abstract String getNome();

}
