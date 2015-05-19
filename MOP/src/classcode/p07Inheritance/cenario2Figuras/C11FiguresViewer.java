package classcode.p07Inheritance.cenario2Figuras;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import classcode.p07Inheritance.layouts.ProportionalLayout;




/**
 * Class FiguresViewer - classe que permite visualizar um array de Figuras num
 * painel de uma frame.
 * 
 * As classes anteriores s�o um exemplo de herena� de classes. NEste ficheiro a
 * classe JPanelFiguras cont�m o c�digo exemplo de se ter um array de
 * refer�ncias para o tipo base e nele conter elementos das suas classes
 * fderivadas.
 * 
 */
public class C11FiguresViewer extends JFrame {
	private static final long serialVersionUID = -4162886183937541L;
	private JFrame frame;

	private JPanel panelFiguras;

	void init(C04Figura[] figuras) {

		// criar a frame
		frame = new JFrame("...: Figures viewer 0.1 :...");
		// definir a dimens�o da frame
		frame.setSize(500, 300);
		// definir que quando se premir o bot�o de close da janela e para fazer
		// dispose � frame, ou seja, para a destruir
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// colocar a frame centrada no �cran
		frame.setLocationRelativeTo(null);
		// criar um gestor proporcional de �rea com rebordo de 10%
		ProportionalLayout pl = new ProportionalLayout(0.1f);
		// colocar esse gestor na frame
		frame.setLayout(pl);

		// criar o painel que conter� as figuras
		panelFiguras = new JPanelFiguras(figuras);
		// adicionar o panel � frame, no seu centro
		frame.add(panelFiguras, ProportionalLayout.CENTER);
		// adicionar ao panel um rebordo a preto
		panelFiguras.setBorder(BorderFactory.createLineBorder(Color.black));

		// colocar a frame visivel, por omiss�o � invis�vel
		frame.setVisible(true);
	}

	/**
	 * M�todod main
	 */
	public static void main(String[] args) {

		// array com v�rias figuras
		final C04Figura[] figuras = new C04Figura[] {
				new C05Recta(new C02Ponto2D(10, 10), new C02Ponto2D(40, 40),
						Color.blue),
				new C06Rectangulo(new C02Ponto2D(100, 10), 90, 50, Color.red),
				new C07Quadrado(new C02Ponto2D(200, 10), 100, Color.green),
				new C08Triangulo(new C02Ponto2D(50, 100), new C02Ponto2D(150,
						100), new C02Ponto2D(50, 150), 100, 50, Color.blue),
				new C09TrianguloIsosceles(new C02Ponto2D(250, 150), 100, 50,
						Color.magenta),
				new C10Elipse(new C02Ponto2D(150, 120), 80, 50, Color.yellow),
				new C10Elipse(new C02Ponto2D(165, 140), 20, 5, Color.red),
				new C10Elipse(new C02Ponto2D(195, 140), 20, 5, Color.red),
				new C11Circulo(new C02Ponto2D(85, 140), 25, Color.orange), };

		// submeter um pedido de execu��o para a Event Dispatch Thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// criar um objecto FiguresViewer
				C11FiguresViewer figFrame = new C11FiguresViewer();
				// construir a frame e torn�-la vis�vel
				figFrame.init(figuras);
			}
		});

	}

}

/**
 * Classe JPanelFiguras - classe auxiliar, n�o se justifica colocar esta classe
 * num ficheiro pr�prio, pois n�o � extensa, nem � uma classe com relev�ncia
 * suficiente para isso e ela s� tem interesse no contexto da classe
 * FiguresViewer. Ela ficar num ficheiro pr�prio s� iria aumentar o n�mero de
 * ficheiros e isso tamb�m n�o facilita a visualiza��o ao n�vel do package
 */
class JPanelFiguras extends JPanel {

	private static final long serialVersionUID = 1L;
	// o array de figuras para serem desenhadas
	C04Figura[] figuras;

	/**
	 * constructor
	 */
	public JPanelFiguras(C04Figura[] figuras) {
		// super();
		this.figuras = figuras;
	}

	/**
	 * M�todo para desenhar as v�rias figuras
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		// deve-se mandar desenhar todo o background primeiro
		super.paintComponent(g);
		// depois desenhar os nossos objectos
		for (int i = 0; i < figuras.length; i++) {
			// figuras[i].translate();
			// C06Rectangulo ref = ((C06Rectangulo) figuras[i]);
			// ref.translate();
			if (figuras[i] instanceof C06Rectangulo) {
				C06Rectangulo ref = (C06Rectangulo) figuras[i];
				ref.translate();
			}
			// if (figuras[i] instanceof C06Rectangulo
			// && !(figuras[i] instanceof C07Quadrado))
			figuras[i].paintComponent(g);
		}
	}
}
