package coinpurse;

import java.util.Comparator;

/**
 * this class for sort a list of money by currency
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
class CompareByCurrency implements Comparator<Valuable> {

	/**
	 * this method for compare the Valuable object with currency
	 * 
	 * @param obj1 is the first object to be compared.
	 * @param obj2 is the second object to be compared.
	 * @return a negative integer, zero, or a positive integer as the first
	 *         currency is less than, equal to, or greater than the second
	 */
	@Override
	public int compare(Valuable obj1, Valuable obj2) {
		return obj1.getCurrency().compareToIgnoreCase(obj2.getCurrency());
	}

}