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
		String currency = "Baht";
		if (value == 1 || value == 2 || value == 5 || value == 10)
			valuable = new Coin(value, currency);
		else if (value == 20 || value == 50 || value == 100 | value == 500 || value == 1000)
			valuable = new BankNote(value, currency);
		else
			throw new IllegalArgumentException();
		return valuable;

	}

}
