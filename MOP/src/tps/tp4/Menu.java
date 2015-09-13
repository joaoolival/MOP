package tps.tp4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import classcode.p07Inheritance.layouts.ProportionalLayout;

public class Menu extends JPanel {
	private static final long serialVersionUID = -3433891252895060316L;
	private boolean createGame = false;
	private Jogo jogo;

	public Menu(Jogo jogo) {
		this.jogo = jogo;

		setBackground(Color.yellow);

		JButton buttonTab4_nivel1 = new JButton("4x4 - Nivel 1");
		buttonTab4_nivel1.setActionCommand("newgame");
		add(buttonTab4_nivel1);

		ActionListener tab4listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					apagaFrame();
					File file = new File(
							"C:\\Users\\Joao\\git\\MOP\\MOP\\src\\tps\\tp4\\levels\\44Easy\\44Easy_01.txt");

					geraTab4(file);
					resetFrame();

					setSize();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		buttonTab4_nivel1.addActionListener(tab4listener);

		JButton buttonTab5_nivel1 = new JButton("5x5 - Nivel 1");
		buttonTab5_nivel1.setActionCommand("newgame");
		add(buttonTab5_nivel1);

		ActionListener tab5listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					apagaFrame();
					File file = new File(
							"C:\\Users\\Joao\\git\\MOP\\MOP\\src\\tps\\tp4\\levels\\55NotSoEasy\\55NotSoEasy_01.txt");

					geraTab5(file);
					resetFrame();

					setSize();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		buttonTab5_nivel1.addActionListener(tab5listener);

		JButton buttonTab6_nivel1 = new JButton("6x6 - Nivel 1");
		buttonTab4_nivel1.setActionCommand("newgame");
		add(buttonTab6_nivel1);

		ActionListener tab6listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					apagaFrame();
					File file = new File(
							"C:\\Users\\Joao\\git\\MOP\\MOP\\src\\tps\\tp4\\levels\\66Medium\\66Medium_01.txt");
					geraTab6(file);
					resetFrame();
					setSize();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		buttonTab6_nivel1.addActionListener(tab6listener);

		JButton buttonTab7_nivel1 = new JButton("7x7 - Nivel 1");
		buttonTab7_nivel1.setActionCommand("newgame");
		add(buttonTab7_nivel1);

		ActionListener tab7listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					apagaFrame();
					File file = new File(
							"C:\\Users\\Joao\\git\\MOP\\MOP\\src\\tps\\tp4\\levels\\77NotSoMedium\\77NotSoMedium_01.txt");
					geraTab7(file);
					resetFrame();
					setSize();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		buttonTab7_nivel1.addActionListener(tab7listener);

		JButton buttonTab8_nivel1 = new JButton("8x8 - Nivel 1");
		buttonTab8_nivel1.setActionCommand("newgame");
		add(buttonTab8_nivel1);

		ActionListener tab8listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					apagaFrame();
					File file = new File(
							"C:\\Users\\Joao\\git\\MOP\\MOP\\src\\tps\\tp4\\levels\\88Hard\\88Hard_01.txt");
					geraTab8(file);
					resetFrame();
					setSize();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		buttonTab8_nivel1.addActionListener(tab8listener);

		JButton buttonTab9_nivel1 = new JButton("9x9 - Nivel 1");
		buttonTab9_nivel1.setActionCommand("newgame");
		add(buttonTab9_nivel1);

		ActionListener tab9listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					apagaFrame();
					File file = new File(
							"C:\\Users\\Joao\\git\\MOP\\MOP\\src\\tps\\tp4\\levels\\99VeryHard\\99VeryHard_01.txt");
					geraTab9(file);
					resetFrame();
					setSize();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		buttonTab9_nivel1.addActionListener(tab9listener);
	}

	public boolean getCreateGame() {
		return createGame;
	}

	public void apagaFrame() {
		jogo.getFrame().setVisible(false);
		jogo.getFrame().dispose();
	}

	public void geraTab4(File file) throws FileNotFoundException {

		JFrame frame = new JFrame();

		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.1f, 0.1f, 0.1f, 0.1f);
		frame.setLayout(cl);

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// frame.add(tabuleiro);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLabel panelLeft = new JLabel("TESTEEEE");
		panelLeft.setBackground(Color.BLUE);

		Tabuleiro tabuleiro = new TabuleiroDim4(file);

		panel.add(tabuleiro, BorderLayout.CENTER);
		frame.add(panelLeft, BorderLayout.EAST);

		frame.add(panel);
		jogo.setFrame(frame);
	}

	public void geraTab5(File file) throws FileNotFoundException {

		Tabuleiro tabuleiro = new TabuleiroDim5(file);
		JFrame frame = new JFrame();
		frame.add(tabuleiro);

		jogo.setFrame(frame);
	}

	public void geraTab6(File file) throws FileNotFoundException {

		Tabuleiro tabuleiro = new TabuleiroDim6(file);
		JFrame frame = new JFrame();
		frame.add(tabuleiro);

		jogo.setFrame(frame);
	}

	public void geraTab7(File file) throws FileNotFoundException {

		Tabuleiro tabuleiro = new TabuleiroDim7(file);
		JFrame frame = new JFrame();
		frame.add(tabuleiro);

		jogo.setFrame(frame);
	}

	public void geraTab8(File file) throws FileNotFoundException {

		Tabuleiro tabuleiro = new TabuleiroDim8(file);
		JFrame frame = new JFrame();
		frame.add(tabuleiro);

		jogo.setFrame(frame);
	}

	public void geraTab9(File file) throws FileNotFoundException {

		Tabuleiro tabuleiro = new TabuleiroDim9(file);
		JFrame frame = new JFrame();
		frame.add(tabuleiro);

		jogo.setFrame(frame);
	}

	public void resetFrame() {
		jogo.getFrame().setTitle("ConnectAll - by Joao Olival");
		jogo.getFrame().setSize(700, 700);

		jogo.getFrame().setLocationRelativeTo(null);
		jogo.getFrame().setDefaultCloseOperation(
				WindowConstants.DISPOSE_ON_CLOSE);
		System.out.println("Frame created...");

	}

	public void setSize() {
		jogo.getFrame().setMinimumSize(new Dimension(400, 400));
		// puts the frame visible (is not visible at start)
		jogo.getFrame().setVisible(true);
	}

}
