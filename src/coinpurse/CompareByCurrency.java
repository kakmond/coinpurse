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
	public int compare(Valuable coin1, Valuable coin2) {
		return coin1.getCurrency().compareToIgnoreCase(coin2.getCurrency());
	}

}