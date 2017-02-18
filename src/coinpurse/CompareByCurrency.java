package coinpurse;

import java.util.Comparator;

/**
 * this class for sort a list of money by currency
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
class CompareByCurrency implements Comparator<Valuable> {

	@Override
	public int compare(Valuable obj1, Valuable obj2) {
		return obj1.getCurrency().compareToIgnoreCase(obj2.getCurrency());
	}

}