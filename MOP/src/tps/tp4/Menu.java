package tps.tp4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel {
	private static final long serialVersionUID = -3433891252895060316L;
	private boolean createGame = false;

	public Menu(){
		setBackground(Color.yellow);
		
		JButton startGame = new JButton("Start Game");
		startGame.setActionCommand("newgame");
		add(startGame);
		
		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCreateGame();
			}
		};

		startGame.addActionListener(al1);
		
	}
	
	public boolean getCreateGame(){
		return createGame;
	}
	
	public void setCreateGame(){
		createGame = true;
	}

}
