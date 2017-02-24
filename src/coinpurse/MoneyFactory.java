package coinpurse;

public abstract class MoneyFactory {

	private static MoneyFactory theMoneyFactory = null;

	public static MoneyFactory getInstance() {
		
		if (theMoneyFactory == null)
			theMoneyFactory = new ThaiMoneyFactory();
		return theMoneyFactory;
	};

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) {
		double doubleValue = Double.parseDouble(value);
		return this.createMoney(doubleValue);
	};

	public static void setMoneyFactory(MoneyFactory factory) {
		theMoneyFactory=factory;
	};
	
	
}
