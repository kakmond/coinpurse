package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Wongsathorn Panichkurkul
 */
public class Coin extends AbstractValuable {
	/** default currency. */
	//public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	//private final double value;
	/** The currency, of course. */
	//private final String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is the value of the coin
	 */
	public Coin(double value) {
		super(value, DEFAULT_CURRENCY);
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is the value of coin
	 * @param currency
	 *            is the currency of coin
	 */
	public Coin(double value, String currency) {
		super(value, currency);

	}

	/**
	 * Get the value of coin.
	 * 
	 * @return value of coin
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of the coin.
	 * 
	 * @return the currency of the coin
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Return the description of the coin with value and currency.
	 * 
	 * @return the description of the coin
	 */
	public String toString() {
		return this.getValue() + "-" + this.getCurrency();
	}

}
