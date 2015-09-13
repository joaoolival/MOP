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

		// add(quadriculas[y][x].getElemento(),x*y);
		// quadriculas[y][x].getElemento().setVisible(true);
		// revalidate();
		// repaint();

	}

	public boolean setPeca(int numero) {

		Trajecto auxTrajecto = tabuleiro.getTrajecto();
		Elemento ultimo = auxTrajecto.getUltimoElemento();

		int ultimoX = ultimo.getQuadricula().getTabX();
		int ultimoY = ultimo.getQuadricula().getTabY();

		if (auxTrajecto.getEstadoPeca() + 1 == numero
				&& ((y == ultimoY && proximidade(x, ultimoX)) || (x == ultimoX && proximidade(
						y, ultimoY)))) {
			auxTrajecto.setElemento(elemento);
			auxTrajecto.aumentaEstadoPeca();
			System.out.println(numero);
			tabuleiro.aumentaNumeroCor();

		}
		return false;
	}

	public boolean proximidade(int actual, int ultimo) {
		if (actual - 1 == ultimo || actual + 1 == ultimo) {
			return true;
		}
		return false;
	}

	public void setLigacao() {
		Trajecto auxTrajecto = tabuleiro.getTrajecto();

		Elemento ultimo = auxTrajecto.getUltimoElemento();
		Elemento penultimo = auxTrajecto.getPenultimoElemento();

		int ultimoX = ultimo.getQuadricula().getTabX();
		int ultimoY = ultimo.getQuadricula().getTabY();

		int penultimoX = -1;
		int penultimoY = -1;

		if (penultimo != null) {
			penultimoX = penultimo.getQuadricula().getTabX();
			penultimoY = penultimo.getQuadricula().getTabY();
		}

		Color auxColor = new Color(
				elemento.getArrayCores()[tabuleiro.getNumeroCor() - 1]
						.getRedValue(),
				elemento.getArrayCores()[tabuleiro.getNumeroCor() - 1]
						.getGreenValue(), elemento.getArrayCores()[tabuleiro
						.getNumeroCor() - 1].getBlueValue());
		System.out.println(tabuleiro.getNumeroCor());

		if (ultimoY == y && (ultimoX + 1 == x || ultimoX - 1 == x)) {
			if (ultimoX < x) {
				/*
				 * if (ultimo instanceof Peca) { Elemento novoElemento = new
				 * LigacaoRectaHorizontal(this, auxColor);
				 * setElemento(novoElemento);
				 * tabuleiro.getTrajecto().setUltimoElemento(novoElemento); }
				 */
				if (ultimo instanceof LigacaoRectaVertical) {
					if (penultimoY != -1 && penultimoY < ultimoY) {
						Elemento novoElemento = new LigacaoCantoNE(
								tabuleiro.getQuadricula(ultimoX, ultimoY),
								auxColor);
						tabuleiro.getQuadricula(ultimoX, ultimoY).setElemento(
								novoElemento);
						tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
					} else if (penultimoY != -1 && penultimoY > ultimoY) {
						Elemento novoElemento = new LigacaoCantoSE(
								tabuleiro.getQuadricula(ultimoX, ultimoY),
								auxColor);
						tabuleiro.getQuadricula(ultimoX, ultimoY).setElemento(
								novoElemento);
						tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
					}
				}
			}
			if (ultimoX > x) {/*
							 * if (ultimo instanceof Peca) { Elemento
							 * novoElemento = new LigacaoRectaHorizontal(this,
							 * auxColor); setElemento(novoElemento);
							 * tabuleiro.getTrajecto
							 * ().setUltimoElemento(novoElemento); }
							 */
				if (ultimo instanceof LigacaoRectaVertical) {
					if (penultimoY != -1 && penultimoY < ultimoY) {
						Elemento novoElemento = new LigacaoCantoNO(
								tabuleiro.getQuadricula(ultimoX, ultimoY),
								auxColor);
						tabuleiro.getQuadricula(ultimoX, ultimoY).setElemento(
								novoElemento);
						tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
					} else if (penultimoY != -1 && penultimoY > ultimoY) {
						Elemento novoElemento = new LigacaoCantoSO(
								tabuleiro.getQuadricula(ultimoX, ultimoY),
								auxColor);
						tabuleiro.getQuadricula(ultimoX, ultimoY).setElemento(
								novoElemento);
						tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
					}
				}
			}

			this.elemento = new LigacaoRectaHorizontal(this, auxColor);
			tabuleiro.getTrajecto().setElemento(elemento);
		}

		else if (ultimoX == x && (ultimoY + 1 == y || ultimoY - 1 == y)) {

			if (ultimoY < y) {
				/*
				 * if (ultimo instanceof Peca) { Elemento novoElemento = new
				 * LigacaoRectaHorizontal(this, auxColor);
				 * setElemento(novoElemento);
				 * tabuleiro.getTrajecto().setUltimoElemento(novoElemento); }
				 */
				if (ultimo instanceof LigacaoRectaHorizontal) {
					if (penultimoX != -1 && penultimoX < ultimoX) {
						Elemento novoElemento = new LigacaoCantoSO(
								tabuleiro.getQuadricula(ultimoX, ultimoY),
								auxColor);
						tabuleiro.getQuadricula(ultimoX, ultimoY).setElemento(
								novoElemento);
						tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
					} else if (penultimoX != -1 && penultimoX > ultimoX) {
						Elemento novoElemento = new LigacaoCantoSE(
								tabuleiro.getQuadricula(ultimoX, ultimoY),
								auxColor);
						tabuleiro.getQuadricula(ultimoX, ultimoY).setElemento(
								novoElemento);
						tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
					}
				}
			}
			if (ultimoY > y) {
				/*
				 * if (ultimo instanceof Peca) { Elemento novoElemento = new
				 * LigacaoRectaVertical(this, auxColor);
				 * setElemento(novoElemento);
				 * tabuleiro.getTrajecto().setUltimoElemento(novoElemento); }
				 */
				if (ultimo instanceof LigacaoRectaHorizontal) {
					if (penultimoX != -1 && penultimoX < ultimoX) {
						Elemento novoElemento = new LigacaoCantoNO(
								tabuleiro.getQuadricula(ultimoX, ultimoY),
								auxColor);
						tabuleiro.getQuadricula(ultimoX, ultimoY).setElemento(
								novoElemento);
						tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
					} else if (penultimoX != -1 && penultimoX > ultimoX) {
						Elemento novoElemento = new LigacaoCantoNE(
								tabuleiro.getQuadricula(ultimoX, ultimoY),
								auxColor);
						tabuleiro.getQuadricula(ultimoX, ultimoY).setElemento(
								novoElemento);
						tabuleiro.getTrajecto().setUltimoElemento(novoElemento);
					}
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
