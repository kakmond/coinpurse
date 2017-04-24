package coinpurse.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListModel;

import coinpurse.Purse;
import coinpurse.Valuable;

/**
 * This class provides a ListModel interface for querying the contents of the
 * purse. It is a kind of adapter.
 * 
 * @author Wongsathorn Panichkurkul
 */
public class PurseListModel extends AbstractListModel<Valuable> implements Observer {

	private Purse purse;
	private ListModel<Valuable> listModel;
	private JList<Valuable> j_list;
	private JFrame frame;
	private JScrollPane scroll;

	/** Constructor of PurseListModel for initialize. */
	public PurseListModel(Purse purse) {
		this.purse = purse;
		frame = new JFrame("Purse Contents");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Returns the length of the list.
	 * 
	 * @return the length of the list.
	 */
	@Override
	public int getSize() {
		return purse.count();
	}

	/**
	 * Returns the value at the specified index.
	 * 
	 * @return the value at the specified index.
	 */
	@Override
	public Valuable getElementAt(int index) {
		return purse.listPurse().get(index);
	}

	/** update receives notification from the purse */
	@Override
	public void update(Observable o, Object arg) {
		fireContentsChanged(this, 0, getSize() - 1);
		j_list.setModel(this);
	}

	/**
	 * Initialize components in the windows.
	 */
	public void initComponents() {
		frame.setSize(300, 500);
		listModel = new PurseListModel(this.purse);
		j_list = new JList<Valuable>(listModel);
		scroll = new JScrollPane(j_list);
		frame.add(scroll);
	}

	/**
	 * For display the graphics window.
	 */
	public void run() {
		initComponents();
		this.frame.setVisible(true);
	}
}
