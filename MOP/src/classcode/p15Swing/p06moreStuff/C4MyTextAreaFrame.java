package classcode.p15Swing.p06moreStuff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;

/**
 * Novidades: JTextArea, JScrollPane, setResizable
 * 
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class C4MyTextAreaFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel panel = null;

	JPanel panelCenter = null;

	private JLabel labelEnterData = null;

	private JScrollPane sp = null;

	private JTextField enterText = null;

	private JTextArea textArea = null;

	private JButton buttonAppend = null;

	private JButton buttonInsertAtCursor = null;

	private JButton buttonRemoveFirst = null;

	private JButton buttonRemoveSelected = null;

	private JButton buttonControlEditing;

	/**
	 * Este m�todo cria toda a frame e coloca-a vis�vel
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My JTextArea frame :...");
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// use of BorderLayout for main frame

		panelCenter = new JPanel(new BorderLayout());

		// build JLabel
		String[] data = {
				"O Janeiro � o primeiro m�s do ano. � um m�s de Inverno, "
						+ "e por isso � frio e chuvoso. ",
				"O m�s de Fevereir � um m�s de pleno Inverno",
				"O m�s de Mar�o ainda � um m�s frio", "Em Abril �guas mil",
				" Em Maio estamos todos � espera do sol.", "Junho � festas",
				"Julho � de pr�-praia", "Agosto � praia total",
				"Setembro voltamos ao mesmo", "Outubro � fazer escalada",
				"Novembro � castanhas e e Outuno",
				"Dezembro � Natal e passagem de ano" };

		// create JTextArea
		textArea = new JTextArea();
		// textArea.setOpaque(true);
		// textArea.setBackground(Color.cyan);

		// colocar todos os elementos de DATA dentro da textArea
		for (String str : data) {
			textArea.append(str + "\n");
		}

		// create JScrollPane to JTextArea
		sp = new JScrollPane(textArea);
		panelCenter.add(sp, BorderLayout.CENTER);
		panelCenter.setBorder(new LineBorder(new Color(120, 240, 140), 20));

		add(panelCenter, BorderLayout.CENTER);

		// Painel dos bot�es
		panel = new JPanel(); // Janel default layout -> FlowLayout
		// BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
		// panel.setLayout(layout);
		panel.setBackground(new Color(240, 220, 120));

		// Labels
		labelEnterData = new JLabel("Data:");
		panel.add(labelEnterData);
		enterText = new JTextField("Ver�o", 10);
		panel.add(enterText);

		// buttonAppend
		buttonAppend = new JButton("Append data");
		buttonAppend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = enterText.getText();
				textArea.append(data + "\n");
			}
		});
		panel.add(buttonAppend);

		// button Insert atCursor
		buttonInsertAtCursor = new JButton("Insert at cursor");
		buttonInsertAtCursor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = enterText.getText();
				textArea.insert(data, textArea.getCaretPosition());
			}
		});
		panel.add(buttonInsertAtCursor);

		// buttonRemove
		buttonRemoveFirst = new JButton("Remove first line");
		buttonRemoveFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea.getLineCount() > 0) {
					try {
						int endOffset = textArea.getLineEndOffset(0);
						textArea.replaceRange(null, 0, endOffset);
					} catch (BadLocationException e1) {
						labelEnterData.setText("Bad location");
					}
				}
			}
		});
		panel.add(buttonRemoveFirst);

		// buttonRemoveSelected
		buttonRemoveSelected = new JButton("Remove selected");
		buttonRemoveSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int startOffset = textArea.getSelectionStart();
				int endOffset = textArea.getSelectionEnd();
				textArea.replaceRange(null, startOffset, endOffset);
			}
		});
		panel.add(buttonRemoveSelected);

		// buttonControlEditing
		buttonControlEditing = new JButton("Disable editing");
		buttonControlEditing.addActionListener(new ActionListener() {
			boolean allowEdit = true;

			public void actionPerformed(ActionEvent e) {
				allowEdit = !allowEdit;
				textArea.setEditable(allowEdit);
				buttonControlEditing.setText(allowEdit ? "Disable editing"
						: "Enable editing");
			}
		});
		panel.add(buttonControlEditing);

		// adicionar o painel do bot�es � frame principal
		add(panel, BorderLayout.PAGE_END);

		getContentPane().setBackground(Color.GREEN);

		// adjust minimum size
		pack();

		// set location
		setLocationRelativeTo(null); // to center a frame

		setResizable(false);

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C4MyTextAreaFrame myFrame = new C4MyTextAreaFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
				System.out
						.println("You can enter text directly in the text area...");
			}
		});
		System.out.println("End of main...");
	}
}
