package tps.tp1.pack3Arrays;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * Esta classe visa aplicar uma transformada ao pixel a uma imagem.
 * 
 * @author ateofilo
 * 
 */
public class P06BitmapTransform {

	/*
	 * TODO Este é o método para implementar o espelhamento. Só devem utilizar
	 * os métodos de image.getRGB(x, y) e image.SetRGB(x, y, pixelColor)
	 */
	public static void transformImage(BufferedImage image) {
		int height = image.getHeight();
		int width = image.getWidth();
		int newPixelColor = 0;
		// ciclo que percorre o array de pixeis
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				// condicao para chegar a imagem em torno do eixo vertical
				if (x > width / 2) {
					newPixelColor = image.getRGB((width - x), y);
				} else {
					newPixelColor = image.getRGB(x, y);
				}
				// set dos novos pixeis com novo RGB
				image.setRGB(x, y, newPixelColor);
				// condicao para chegar a imagem final
				if (y > height / 2) {
					newPixelColor = image.getRGB(x, (height - y));
				} else {
					newPixelColor = image.getRGB(x, y);
				}
				// set dos novos pixeis com o valor final RGB
				image.setRGB(x, y, newPixelColor);
			}
		}
	}

	/**
	 * Método de inicialização da frame
	 * 
	 */
	public static void init() throws IOException {
		// the frame
		JFrame frame = new JFrame();

		// frame should be disposed when we press close button
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// set frame size
		frame.setSize(400, 300);

		// center the frame
		frame.setLocationRelativeTo(null);

		// read the image to memory
		BufferedImage image = ImageIO.read(P06BitmapTransform.class
				.getResource("images/image1.jpg"));

		// transform image
		transformImage(image);

		// show the image inside a label
		ImageIcon img = new ImageIcon(image);
		JLabel label = new JLabel(img, JLabel.CENTER);
		// add the label to frame
		frame.add(label);

		// turn frame visible
		frame.setVisible(true);
	}

	/**
	 * Método main - execution entry point
	 */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {

					// task to be done
					init();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

	}

}
