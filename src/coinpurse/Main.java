package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Wongsathorn Panichkurkul
 */
public class Main {
	// the capacity of the purse
	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args not used
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
		ConsoleDialog consoleDialog = new ConsoleDialog(purse, "Thailand");
		consoleDialog.run();
	}
}
