package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import coinpurse.Purse;

/**
 * An observer that displays "FULL","EMPTY", or number of object in the
 * purse (when not full or empty).
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class PurseStatusObserver implements Observer {

	private JFrame frameStatus;
	private JLabel textStatus;
	private JProgressBar progressBar;

	/**
	 * Constructor of PurseStatusObserver.
	 */
	public PurseStatusObserver() {
		// nothing to initialize
	}

	/** Update receives notification from the purse */
	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			progressBar.setMaximum(purse.getCapacity());
			progressBar.setMinimum(0);
			if (purse.isFull()) {
				progressBar.setValue(purse.count());
				textStatus.setText(" FULL");
			} else if (purse.count() == 0) {
				progressBar.setValue(purse.count());
				textStatus.setText(" EMPTY");
			} else {
				progressBar.setValue(purse.count());
				textStatus.setText(" " + purse.count());
			}
		}
	}

	/**
	 * Initialize components in the windows.
	 */
	private void initComponents() {
		this.frameStatus = new JFrame();
		this.frameStatus.setTitle("Purse Status");
		this.frameStatus.setSize(325, 125);
		this.textStatus = new JLabel(" EMPTY");
		this.progressBar = new JProgressBar();
		this.textStatus.setFont(new Font("Serif", Font.BOLD, 45));
		frameStatus.add(textStatus, BorderLayout.NORTH);
		frameStatus.add(progressBar, BorderLayout.SOUTH);
		frameStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * For display the graphics window.
	 */
	public void run() {
		this.initComponents();
		frameStatus.setVisible(true);
	}

}
