package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {

		List<Valuable> temp;
		if (amount == 0) {
			List<Valuable> blank = new ArrayList<Valuable>();
			return blank;
		}
		if (money.size() == 0)
			return null;
		if ((temp = withdraw(amount, money.subList(1, money.size()))) != null) {
			return temp;
		}
		if ((temp = withdraw(amount - money.get(0).getValue(), money.subList(1, money.size()))) != null) {
			temp.add(money.get(0));
			return temp;
		}
		return null;

	}
}
