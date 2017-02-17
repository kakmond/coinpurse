package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Wongsathorn Panichkurkul
 */
public class Coin implements Comparable<Coin> , Valuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value is the value of the coin
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value is the value of coin
	 * @param currency is the currency of coin
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
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
	 * check two coins are equal or not ,it will be equal if they have the same
	 * value and currency.
	 * 
	 * @param obj is the object that you want to compare.
	 * @return true if they have the same value and currency, 
	 *         false if they are not same
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin other = (Coin) obj;
		return other.getValue() == this.getValue() && other.getCurrency().equals(this.getCurrency());
	}

	/**
	 * Return the description of the coin with value and currency.
	 * 
	 * @return the description of the coin
	 */
	public String toString() {
		return this.getValue() + "-" + this.getCurrency();
	}

	/**
	 * Compare two coin with value, return -1 if object is null or this coin is
	 * less than another coin, return 1 if this coin value more than another
	 * coin, return 0 if it has a same value.
	 * 
	 * @param other is the coin object that you want to compare with
	 * @return return -1 if object is null or this coin is less than another coin, 
	 *         return 1 if this coin value more than another coin, 
	 *         return 0 if it has a same value.
	 */
	@Override
	public int compareTo(Coin other) {
		if (other == null)
			return -1;
		if (this.getValue() - other.getValue() > 0)
			return 1;
		else if (this.getValue() - other.getValue() == 0)
			return 0;
		else
			return -1;
	}

}
