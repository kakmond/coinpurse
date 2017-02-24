package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {

	@Override
	public Valuable createMoney(double value) {
		Valuable valuable;
		String currency;
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) {
			currency = "Sen";
			valuable = new Coin(value, currency);
		} else if (value == 1 || value == 2 || value == 5 | value == 10 || value == 20 || value == 50 || value == 100) {
			currency = "Ringgit";
			
			valuable = new BankNote(value, currency);
		} else
			throw new IllegalArgumentException();
		return valuable;
	}

}
