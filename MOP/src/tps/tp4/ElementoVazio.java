package tps.tp4;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ElementoVazio extends Elemento {
	private static final long serialVersionUID = 5911365035416195247L;
	private String nome;

	public ElementoVazio(Quadricula quadricula) {
		super(Color.GRAY, quadricula);
		this.nome = "Vazio";

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON3) {
					System.out.println("right");

				}
				if (e.getButton() == MouseEvent.BUTTON1) {
					/*
					 * quadricula.setElemento(new LigacaoCantoSO(quadricula, new
					 * Color(getArrayCores()[0].getRedValue(),
					 * getArrayCores()[0].getGreenValue(),
					 * getArrayCores()[0].getBlueValue())));
					 */
					Tabuleiro auxTabuleiro = quadricula.getTabuleiro();
					Trajecto auxTrajecto = auxTabuleiro.getTrajecto();

					/*
					 * if(auxTrajecto.estaVazio()){ quadricula.setElemento(new
					 * LigacaoRectaHorizontal(quadricula, new
					 * Color(getArrayCores()[0].getRedValue(),
					 * getArrayCores()[0].getGreenValue(),
					 * getArrayCores()[0].getBlueValue()))); }
					 */

					quadricula.setLigacao();

				}
			}
		});
	}

	public String getNome() {
		return nome;
	}

	public boolean podeEntrar(int currentValue) {

		return false;
	}

	/*
	 * @Override public void paintComponent(Graphics g) {
	 * g.setColor(Color.BLUE); g.fillOval(20, 20, 20, 20); }
	 */
}
