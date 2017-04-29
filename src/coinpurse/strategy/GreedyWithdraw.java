package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;

public class GreedyWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> valuables) {
		double moneyLeft = amount;
		List<Valuable> valuablelist = new ArrayList<Valuable>();
		Collections.sort(valuables, new Comparator<Valuable>() {
			@Override
			public int compare(Valuable o1, Valuable o2) {
				if (o1.getValue() > o2.getValue())
					return 1;
				else if (o1.getValue() < o2.getValue())
					return -1;
				else
					return 0;
			}
		});
		Collections.reverse(valuables);
		for (Valuable valuable : valuables) {
			if (moneyLeft - valuable.getValue() >= 0) {
				moneyLeft -= valuable.getValue();
				valuablelist.add(valuable);
				if (moneyLeft == 0)
					break;
			}
		}
		if (moneyLeft == 0) {
			for (Valuable valuable : valuablelist)
				valuables.remove(valuable);
			return valuablelist;
		}
		return null;
	}
}
