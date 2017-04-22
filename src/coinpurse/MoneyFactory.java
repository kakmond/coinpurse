package coinpurse;

/**
 * This class for create the Valuable by using the local currency.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public abstract class MoneyFactory {

	private static MoneyFactory theMoneyFactory = null;
	/** the next number of serial number */
	public static long nextSerialNumber = 1000000;
	/** the current currency */
	public static String CURRENCY = "Baht";

	/**
	 * constructor is protected to prevent other classes from creating objects
	 * except subclass.
	 */
	protected MoneyFactory() {
	}

	/**
	 * Get an instance of MoneyFactory.
	 * 
	 * @return MoneyFactory instance.
	 */
	public static MoneyFactory getInstance() {
		if (theMoneyFactory == null)
			theMoneyFactory = new ThaiMoneyFactory();
		return theMoneyFactory;
	};

	/**
	 * Create a new money object in the local currency.
	 * 
	 * @param value is the value that you want to create.
	 * @return the Valuable of object.
	 * @throws IllegalArgumentException if value is not valid.
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * Accepts money value as a String and create a new money object in the
	 * local currency.
	 * 
	 * @param value is the value that you want to create.
	 * @return the Valuable of object.
	 * @throws IllegalArgument if value is not a valid number.
	 */
	public Valuable createMoney(String value) {
		try {
			double doubleValue = Double.parseDouble(value);
			return this.createMoney(doubleValue);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	};

	/**
	 * Set the local factory.
	 * 
	 * @param factory is the subclass of MoneyFactory.
	 */
	public static void setMoneyFactory(MoneyFactory factory) {
		if (factory instanceof MalayMoneyFactory)
			CURRENCY = "Ringgit";
		else
			CURRENCY = "Baht";
		theMoneyFactory = factory;
	}
}