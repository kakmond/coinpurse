package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {


	
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
