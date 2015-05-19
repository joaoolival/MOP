package classcode.p15Swing.p06moreStuff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Novidades: JList, DefaultListModel, JScrollPane
 * 
 * Uma JList permite visualizar os seus elementos um por cada linha.
 * 
 * Podemos colocar na JList um ListModel que � um objecto que cont�m um modelo
 * de dados e que a JList sabe mostrar. O ListModel tem de ser registado na
 * JList. Assim a JList sabe quando o ListModel foi modificado e actualiza o seu
 * output. Quando se cria a JList passando o listModel, o JList regista-se no
 * listmodel.
 * 
 * Quando ocorre uma altera��o � ListModel, todos os listeners registados nela
 * s�o chamados.
 * 
 * Temos portanto uma arquitectura de MODEL e VIEWER (padr�o Model View Control
 * - MVC). O controle aos dados � realizado pelos bot�es e l�gica da interface
 * 
 * Pode-se utilizar uma JList sem model, mas nesse caso deve-se utilizar um
 * array de dados para passar os dados para a JLIST, esse array � copiado e
 * imut�vel.
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class C2MyListAndScrollFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton buttonAppend = null;

	private JButton buttonRemoveFirst = null;

	private JButton buttonRemoveSelected = null;

	JPanel panel = null;

	JPanel panelCenter = null;

	private JLabel labelAppend = null;

	private JTextField textToAppend = null;

	// a JList
	private JList<String> list = null;

	// o ScrollPane oara que a lista tenha scroll
	private JScrollPane sp = null;

	// o model para que se possa alterar os dados da lista e as altera��es sejam
	// reflectidas na vista
	private DefaultListModel<String> listModel = null;

	/**
	 * Este m�todo cria toda a frame e coloca-a vis�vel
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My JList frame :...");
		// set size
		setSize(700, 200);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// use of BorderLayout for main frame

		// build JLabel
		String[] data = { "Janeiro", "Fevereiro", "Mar�o", "Abril", "Maio",
				"Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro",
				"Dezembro" };

		// bvuild the list model - este DefaultListModel � baseado num vector
		listModel = new DefaultListModel<String>();
		// colocar todos os elementos de DATA dentro da listmodel
		for (String str : data) {
			listModel.addElement(str);
		}

		// build center panel
		panelCenter = new JPanel();

		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.05f, 0.05f, 0.05f, 0.05f);
		panelCenter.setLayout(cl);

		// criar a lista com o model j� preenchido
		list = new JList<String>(listModel);
		sp = new JScrollPane(list);
		panelCenter.add(sp, ProportionalLayout.CENTER);
		// panelCenter.add(list, ProportionalLayout.CENTER);

		panelCenter.setBackground(new Color(120, 240, 140));
		add(panelCenter, BorderLayout.CENTER);

		// Painel dos bot�es
		panel = new JPanel(); // Janel default layout -> FlowLayout
		panel.setBackground(new Color(240, 220, 120));

		// buttonAppend
		labelAppend = new JLabel("Data to append:");
		panel.add(labelAppend);
		textToAppend = new JTextField("Ver�o", 10);
		panel.add(textToAppend);

		buttonAppend = new JButton("Append data");
		buttonAppend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = textToAppend.getText();
				listModel.addElement(data);
				int lastIndex = listModel.getSize() - 1;
				list.ensureIndexIsVisible(lastIndex);
				list.setSelectedIndex(lastIndex);
			}
		});
		panel.add(buttonAppend);

		// buttonRemove
		buttonRemoveFirst = new JButton("Remove first");
		buttonRemoveFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listModel.getSize() > 0) {
					String str = (String) listModel.remove(0);
					textToAppend.setText(str);
				}

			}
		});
		panel.add(buttonRemoveFirst);

		// buttonRemoveSelected
		buttonRemoveSelected = new JButton("Remove selected");
		buttonRemoveSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selValues = list.getSelectedIndices();
				for (int index = selValues.length - 1; index >= 0; --index) {
					String str = (String) listModel.remove(selValues[index]);
					System.out.println("Remo��o em " + index + " -> " + str);
				}
			}
		});
		panel.add(buttonRemoveSelected);

		// adicionar o painel do bot�es � frame principal
		add(panel, BorderLayout.PAGE_END);

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
				C2MyListAndScrollFrame myFrame = new C2MyListAndScrollFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}
