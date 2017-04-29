package coinpurse;

import java.util.ResourceBundle;

import coinpurse.gui.PurseBalanceObserver;
import coinpurse.gui.PurseListModel;
import coinpurse.gui.PurseStatusObserver;
import coinpurse.strategy.RecursiveWithdraw;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Wongsathorn Panichkurkul
 */
public class Main {
	// the capacity of the purse
	private static final int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used.
	 */
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyFactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException e) {
			System.out.println(factoryclass + " is not type MoneyFactory");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error creating MoneyFactory " + e.getMessage());
			e.printStackTrace();
		}
		if (factory == null)
			System.exit(1);
		else
			MoneyFactory.setMoneyFactory(factory);

		Purse purse = new Purse(CAPACITY);
		purse.setWithdrawStrategy(new RecursiveWithdraw());
		ConsoleDialog consoleDialog = new ConsoleDialog(purse);
		PurseBalanceObserver balanceObserver = new PurseBalanceObserver();
		PurseStatusObserver statusObserver = new PurseStatusObserver();
		PurseListModel list = new PurseListModel(purse);
		purse.addObserver(balanceObserver);
		purse.addObserver(statusObserver);
		purse.addObserver(list);
		list.run();
		balanceObserver.run();
		statusObserver.run();
		consoleDialog.run();
	}
}
