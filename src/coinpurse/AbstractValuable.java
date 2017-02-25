package coinpurse;

/**
 * This class is the parent class for Coin and Banknote.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public abstract class AbstractValuable implements Valuable {

	/** default currency. */
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the valuable. */
	protected double value;
	/** The currency of the valuable. */
	protected String currency;

	/**
	 * Initialize a AbstractValuable with given value and currency.
	 * 
	 * @param value is the value of the BankNote
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Compare two Valuable with value. Order items by currency so items with
	 * same currency are grouped together, and if currency is the same then
	 * order by value.
	 *
	 * @param other is the Valuable object that you want to compare with
	 * @return if currency is the same, compare by value. if currency is not
	 *         same, compare by currency.
	 */
	public int compareTo(Valuable other) {
		if (this.getCurrency().equals(other.getCurrency())) {
			if (this.getValue() > other.getValue())
				return 1;
			else if (this.getValue() < other.getValue())
				return -1;
			else
				return 0;
		} else
			return this.getCurrency().compareToIgnoreCase(other.getCurrency());
	}

	/**
	 * check two Valuable are equal or not ,it will be equal if they have the
	 * same value and currency.
	 * 
	 * @param obj is the object that you want to compare.
	 * @return true if they have the same value and currency, false if they are
	 *         not same
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Valuable other = (Valuable) obj;
		return other.getValue() == this.getValue() && other.getCurrency().equals(this.getCurrency());
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

}
