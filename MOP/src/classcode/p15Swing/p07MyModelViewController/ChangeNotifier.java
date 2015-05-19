package classcode.p15Swing.p07MyModelViewController;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * Esta classe suporta o registo de ChangeListeners e a divulgação dos
 * ChangeEvents. Os objectos que são MODEL devem possuir um objecto desta
 * classe.
 * 
 */
public class ChangeNotifier implements IChangeNotifier {

	protected ArrayList<ChangeListener> listenerList = new ArrayList<ChangeListener>();

	protected List<ChangeListener> getChangeListeners() {
		return listenerList;
	}

	class DoFireState implements Runnable {
		ChangeListener listener;
		ChangeEvent e;

		public DoFireState(ChangeListener listener, ChangeEvent e) {
			this.listener = listener;
			this.e = e;
		}

		public void run() {
			listener.stateChanged(e);
		}
	}

	public void fireStateChanged(ChangeEvent e) {
		for (ChangeListener listener : listenerList) {
			SwingUtilities.invokeLater(new DoFireState(listener, e));
		}
	}

	public void addChangeListener(ChangeListener l) {
		listenerList.add(l);
	}
}
