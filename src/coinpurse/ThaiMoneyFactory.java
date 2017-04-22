package coinpurse;

/**
 * 
 * this class for create money of Thai.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	/**
	 * Create money of Thai.
	 * 
	 * @param value is a value that you want to create.
	 * @return the Valuable object.
	 * @throws IllegalArgumentException if value is not valid.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable valuable;
		if (value == 1 || value == 2 || value == 5 || value == 10)
			valuable = new Coin(value, "Baht");
		else if (value == 0.5 || value == 0.25)
			valuable = new Coin(value, "Satang");
		else if (value == 20 || value == 50 || value == 100 | value == 500 || value == 1000)
			valuable = new BankNote(value, "Baht");
		else
			throw new IllegalArgumentException();
		return valuable;
	}

	/**
	 * Test the MoneyFactory.
	 * 
	 * @param arg not used
	 */
	public static void main(String[] arg) {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(0.5);
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney("500.0");
		System.out.println(m2.toString());
	}

}
