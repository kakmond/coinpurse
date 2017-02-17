package coinpurse;

public class BankNote implements Valuable {

	public static final String DEFAULT_CURRENCY = "Baht";
	private static long nextSerialNumber = 1000000;
	/** Value of the BankNote. */
	private final double value;
	/** The currency of the BankNote. */
	private final String currency;
	private long serialNumber;

	/**
	 * Initialize a BankNote with given value using the default currency.
	 * 
	 * @param value
	 *            is the value of the BankNote
	 */
	public BankNote(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
		this.serialNumber = this.nextSerialNumber;
		this.nextSerialNumber++;
	}

	/**
	 * Initialize a BankNote with given value and currency.
	 * 
	 * @param value
	 *            is the value of BankNote
	 * @param currency
	 *            is the currency of BankNote
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = this.nextSerialNumber;
		this.nextSerialNumber++;
	}

	/**
	 * Get the value of BankNote.
	 * 
	 * @return value of BankNote
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of BankNote.
	 * 
	 * @return the currency of BankNote
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Get the serial number of the BankNote
	 * 
	 * @return the serial number of the BankNote
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * check two BankNote are equal or not ,it will be equal if they have the
	 * same value and currency.
	 * 
	 * @param obj
	 *            is the object that you want to compare.
	 * @return true if they have the same value and currency, false if they are
	 *         not same
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) obj;
		return other.getValue() == this.getValue() && other.getCurrency().equals(this.getCurrency());
	}

	/**
	 * Return the description of the BankNote with value and currency.
	 * 
	 * @return the description of the BankNote
	 */
	public String toString() {
		return this.getValue() + "-" + this.getCurrency() + " note [" + this.serialNumber + "]";
	}

}
