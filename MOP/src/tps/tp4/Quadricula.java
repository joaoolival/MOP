package tps.tp4;

import java.awt.Color;

public class Quadricula {
	static final Color BACKGROUNDCOLOR = new Color(100, 100, 100);

	private int x;
	private int y;
	private Elemento elemento;
	private Tabuleiro tabuleiro;

	public Quadricula(Tabuleiro tabuleiro, int x, int y) {
		this.tabuleiro = tabuleiro;
		this.x = x;
		this.y = y;
		this.elemento = new ElementoVazio(this);

	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	int getTabX() {
		return x;
	}

	int getTabY() {
		return y;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void refresh() {
		tabuleiro.removeAll();
		// refresh the panel.
		tabuleiro.updateUI();
		tabuleiro.setQuad();
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
		refresh();
		getTabuleiro().getTrajecto().setElemento(elemento);
		// add(quadriculas[y][x].getElemento(),x*y);
		// quadriculas[y][x].getElemento().setVisible(true);
		// revalidate();
		// repaint();

	}

	public void setLigacao() {
		Trajecto auxTrajecto = tabuleiro.getTrajecto();
		Elemento auxElemento = auxTrajecto.getUltimoElemento();
		
		int auxX = auxElemento.getQuadricula().getTabX();
		int auxY = auxElemento.getQuadricula().getTabY();
		Color auxColor = new Color(
				elemento.getArrayCores()[0].getRedValue(),
				elemento.getArrayCores()[0].getGreenValue(),
				elemento.getArrayCores()[0].getBlueValue());

		if (auxY == y && (auxX + 1 == x || auxX - 1 == x)) {
			if (auxElemento instanceof LigacaoRectaVertical) {
				if (auxX + 1 == x) {
					Elemento novoElemento = new LigacaoCantoNE(tabuleiro.getQuadricula(auxX, auxY),auxColor);
					tabuleiro.getQuadricula(auxX, auxY)
							.setElemento(novoElemento);
					tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
				}
				else if(auxX - 1 == x){
					Elemento novoElemento = new LigacaoCantoNO(tabuleiro.getQuadricula(auxX, auxY),auxColor);
					tabuleiro.getQuadricula(auxX, auxY)
							.setElemento(novoElemento);
					tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
				}
			}
			this.elemento = new LigacaoRectaHorizontal(this, auxColor);
			tabuleiro.getTrajecto().setElemento(elemento);
		}

		if (auxX == x && (auxY + 1 == y || auxY - 1 == y)) {
			if (auxElemento instanceof LigacaoRectaHorizontal) {
				if (auxY + 1 == y) {
					Elemento novoElemento = new LigacaoCantoSE(tabuleiro.getQuadricula(auxX, auxY),auxColor);
					tabuleiro.getQuadricula(auxX, auxY)
							.setElemento(novoElemento);
					tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
				}
				else if(auxY - 1 == y){
					Elemento novoElemento = new LigacaoCantoSO(tabuleiro.getQuadricula(auxX, auxY),auxColor);
					tabuleiro.getQuadricula(auxX, auxY)
							.setElemento(novoElemento);
					tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
				}
			}
			this.elemento = new LigacaoRectaVertical(this, auxColor);
			tabuleiro.getTrajecto().setElemento(elemento);
		}

		refresh();
	}

	public boolean equals(Quadricula quadricula) {
		if (x == quadricula.getTabX() && y == quadricula.getTabY()) {
			return true;
		}
		return false;
	}

}
