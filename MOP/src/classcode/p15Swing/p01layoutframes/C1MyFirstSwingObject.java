package classcode.p15Swing.p01layoutframes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Frame, JLabel
 * 
 * Criar uma JFrame, dar-lhe tamanho, colocar-lhe um JLabel, alterar cores e
 * font, posicion�-la no centro do ecran e destru�-la quando se clicar no icon
 * de close. Excepto o acto de criar a frame, todos os outros podem ser
 * comentados e observar-se os seus efeitos
 * 
 * @author Ant�nio Te�filo
 * 
 */

public class C1MyFirstSwingObject {

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new MyRun());
		System.out.println("End of main...");
	}

	static class MyRun implements Runnable {
		public void run() {
			createAndShowGUI();
		}
	}

	public static void main2(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
		System.out.println("End of main...");

		// Runnable doRun = new Runnable() {
		// public void run() {
		// createAndShowGUI();
		// }
		// };
		// javax.swing.SwingUtilities.invokeLater(doRun);
	}

	public static void createAndShowGUI() {
		// create a JFrame
		JFrame frame = new JFrame();

		// set title
		frame.setTitle("...: My first frame :...");

		// set size
		frame.setSize(700, 200);

		// set location
		frame.setLocationRelativeTo(null); // to center a frame

		// set what appends when close button is pressed
		// default: HIDE_ON_CLOSE

		// verificar o comportamento com as op��es seguintes. DISPOSE_ON_CLOSE �
		// a op��o que queremos
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		// frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Criar a label com algum texto
		JLabel label1 = new JLabel("Ol�");

		// colocar a label dentro da frame
		frame.getContentPane().add(label1);
		// tamb�m se poderia fazer:
		// frame.add(label1);

		// obter e afectar o texto da label
		label1.setText(label1.getText() + " boas f�rias");

		// indicar que o texto � para ficar centrado horizontalmente,
		// verticalmente j� o � por omiss�o
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		// label1.setVerticalAlignment(SwingConstants.BOTTOM);

		// mudar a font do texto
		label1.setFont(new Font("Courier", Font.BOLD, 60));

		// mudar a font do texto
		String fontType = "Comic Sans MS";
		int size = 40;
		Font f1 = new Font(fontType, Font.BOLD, size);
		label1.setFont(f1);

		// colocar uma cor nas letras
		label1.setForeground(Color.magenta);
		label1.setForeground(new Color(200, 0, 0));

		// colocar uma cor de fundo
		label1.setOpaque(true);
		label1.setBackground(Color.yellow);
		// label1.setBackground(new Color(200, 150, 200));

		// reduzir a frame �s m�nimas dimens�es
		frame.pack();

		// set location at center
		frame.setLocationRelativeTo(null);

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);

		// frame.setResizable(false);

		// n�o se deve fazer sleep � thread do swing (Events Dispatch Thread)
		// eset sleep ir� paralizar toda a frame
		// try {
		// Thread.sleep(8000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		// frame.setSize(400, 700);
		// frame.setLocationRelativeTo(null); // to center a frame

		// life goes on
		System.out.println("Frame created...");
	}
}
