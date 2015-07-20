package tps.tp4;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

public class Tabuleiro extends JPanel {
	private static final long serialVersionUID = -2644847326361294863L;
	private Quadricula[][] quadriculas;
	private Trajecto trajecto;

	public Tabuleiro(int nRows, int nCols) throws FileNotFoundException {

		GridLayout gl1 = new GridLayout(nRows, nCols);
		setLayout(gl1);
		gl1.setVgap(2);
		gl1.setHgap(2);

		Quadricula[][] quadriculas = new Quadricula[nRows][nCols];
		for (int i = 0; i < quadriculas.length; i++) {
			for (int j = 0; j < quadriculas.length; j++) {
				quadriculas[i][j] = new Quadricula(this, j, i);
			}
		}
		this.quadriculas = quadriculas;
		setQuad();
		setBackground(Color.yellow);
		this.trajecto = new Trajecto(this);
		setPecas();
	}

	public Trajecto getTrajecto() {
		return trajecto;
	}

	public void setPecas() throws FileNotFoundException {
		File file = new File(
				"C:\\Users\\Joao\\git\\MOP\\MOP\\src\\tps\\tp4\\levels\\55NotSoEasy\\55NotSoEasy_01.txt");
		Scanner fileScan = new Scanner(file);
		boolean waitDim = true;

		while (fileScan.hasNextLine()) {

			String line = fileScan.nextLine();

			Scanner lineScan = new Scanner(line);
			// ver se a linha e null
			while (lineScan.hasNext()) {
				System.out.println(lineScan.next());
				/*if (lineScan.hasNextInt()) {
					if (waitDim) {
						int dim = lineScan.nextInt();
						waitDim = false;
					}
					System.out.println("entre");
					int x = lineScan.nextInt();
					int y = lineScan.nextInt();

					System.out.println(x);
					System.out.println(y);

				}*/
			}
			lineScan.close();
		}
		fileScan.close();

	}

	public void setQuad() {
		for (int i = 0; i < quadriculas.length; i++) {
			for (int j = 0; j < quadriculas.length; j++) {
				add(quadriculas[i][j].getElemento());
			}
		}
	}

	public Quadricula getQuadricula(int x, int y) {
		return quadriculas[y][x];
	}

	public void setElemento(int x, int y, Elemento elemento) {
		quadriculas[y][x].setElemento(elemento);
	}

	public Quadricula[][] getGrids() {
		return quadriculas;
	}
}
