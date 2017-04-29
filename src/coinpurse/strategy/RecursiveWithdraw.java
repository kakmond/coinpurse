package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

/**
 * The strategy that withdraw money in the Purse with recursive algorithm.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

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
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> temp;
		if (amount == 0) {
			List<Valuable> blank = new ArrayList<Valuable>();
			return blank;
		}
		if (money.size() == 0)
			return null;
		if ((temp = withdraw(amount, money.subList(1, money.size()))) != null)
			return temp;
		if ((temp = withdraw(amount - money.get(0).getValue(), money.subList(1, money.size()))) != null) {
			temp.add(money.get(0));
			return temp;
		}
		return null;
	}
}
