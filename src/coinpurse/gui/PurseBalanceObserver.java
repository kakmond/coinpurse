package coinpurse.gui;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import coinpurse.MoneyFactory;
import coinpurse.Purse;

/**
 * An observer to display the balance in the Purse.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class PurseBalanceObserver implements Observer {

	private JLabel textBalance;
	private JFrame frameBalance;

	/**
	 * Constructor of PurseBalanceObserver.
	 */
	public PurseBalanceObserver() {
		// nothing to initialize
	}

	/**
	 * Initialize components in the windows.
	 */
	private void initComponents() {
		this.frameBalance = new JFrame();
		this.frameBalance.setSize(325, 115);
		this.frameBalance.setTitle("Purse Balance");
		this.textBalance = new JLabel("0 " + MoneyFactory.CURRENCY);
		this.textBalance.setFont(new Font("Serif", Font.BOLD, 45));
		frameBalance.add(textBalance);
		frameBalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * For display the graphics window.
	 */
	public void run() {
		this.initComponents();
		frameBalance.setVisible(true);
	}

	/** Update receives notification from the purse */
	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			textBalance.setText("Balance is: " + purse.getBalance() + " " + MoneyFactory.CURRENCY);
			this.frameBalance.pack();
		}
	}

}
