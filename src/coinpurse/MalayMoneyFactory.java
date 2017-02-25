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
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) {
			String currency = "Sen";
			valuable = new Coin(value, currency);
		} else if (value == 1 || value == 2 || value == 5 | value == 10 || value == 20 || value == 50 || value == 100) {
			String currency = "Ringgit";
			valuable = new BankNote(value, currency);
		} else
			throw new IllegalArgumentException();
		return valuable;
	}

}
