package coinpurse;

/**
 * A banknote with a monetary value , currency and serial number.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class BankNote extends AbstractValuable {

	/** serial number of the BankNote. */
	private long serialNumber;

	/**
	 * Initialize a BankNote with given value using the default currency.
	 * 
	 * @param value is the value of the BankNote
	 */
	public BankNote(double value) {
		super(value, DEFAULT_CURRENCY);
		this.setSerialNumber(MoneyFactory.nextSerialNumber);
		MoneyFactory.nextSerialNumber++;
	}

	/**
	 * Initialize a BankNote with given value and currency.
	 * 
	 * @param value is the value of BankNote
	 * @param currency is the currency of BankNote
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		this.setSerialNumber(MoneyFactory.nextSerialNumber);
		MoneyFactory.nextSerialNumber++;
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
	public long getSerialNumber() {
		return this.serialNumber;
	}

	/**
	 * Set the serial number of the BankNote
	 * 
	 * @param serialNumber is the serial number that you want to set
	 */
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
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
