package coinpurse;

/**
 * 
 * this class for create money of Malaysian.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class MalayMoneyFactory extends MoneyFactory {

	/**
	 * Create money of Malaysian.
	 * 
	 * @param value is a value that you want to create.
	 * @return the Valuable object.
	 * @throws IllegalArgumentException if value is not valid.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable valuable;
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50)
			valuable = new Coin(value, "Sen");
		else if (value == 1 || value == 2 || value == 5 | value == 10 || value == 20 || value == 50 || value == 100)
			valuable = new BankNote(value, "Ringgit");
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
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(0.5);
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney("100.0");
		System.out.println(m2.toString());
	}

}
