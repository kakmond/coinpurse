package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;

/**
 * The strategy that withdraw money in the Purse with greedy algorithm.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {

	/**
	 * Find and return a collection of money that will enable the purse to
	 * withdraw the requested amount and sorted by largest to smallest.
	 * 
	 * @param amount
	 *            is the amount of money to withdraw
	 * @param money
	 *            the contents that are available for possible withdraw. Must
	 *            not be null, but may be an empty list. This list is not
	 *            modified.
	 * @return if a solution is found, return a List containing references from
	 *         the money parameter (List) whose sum equals the amount. If a
	 *         solution is not found, returns null.
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> valuables) {
		double moneyLeft = amount;
		List<Valuable> valuablelist = new ArrayList<Valuable>();
		Collections.sort(valuables, new Comparator<Valuable>() {
			@Override
			public int compare(Valuable o1, Valuable o2) {
				if (o1.getValue() > o2.getValue())
					return -1;
				else if (o1.getValue() < o2.getValue())
					return 1;
				else
					return 0;
			}
		});
		for (Valuable valuable : valuables) {
			if (moneyLeft - valuable.getValue() >= 0) {
				moneyLeft -= valuable.getValue();
				valuablelist.add(valuable);
				if (moneyLeft == 0)
					break;
			}
		}
		if (moneyLeft == 0)
			return valuablelist;
		return null;
	}
}
