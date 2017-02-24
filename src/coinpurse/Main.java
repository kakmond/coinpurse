package coinpurse;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Wongsathorn Panichkurkul
 */
public class Main {
	//the capacity of the purse
	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		Purse purse = new Purse(CAPACITY);
		ConsoleDialog consoleDialog = new ConsoleDialog(purse);
		consoleDialog.run();
		/*MoneyFactory factory=MoneyFactory.getInstance();
		Valuable m=factory.createMoney(5);
		System.out.println(m.toString());
		Valuable m2=factory.createMoney("10.0");
		System.out.println(m2.toString());
		
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		Valuable m3=MoneyFactory.getInstance().createMoney(10);
		System.out.println(m3.toString());*/
	}
}
