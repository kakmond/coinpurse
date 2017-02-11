package coinpurse;

import java.util.Comparator;

/**
 * this class for sort a list of coins by currency
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
class CompareByCurrency implements Comparator<Coin> {

	@Override
	public int compare(Coin coin1, Coin coin2) {
		return coin1.getCurrency().compareToIgnoreCase(coin2.getCurrency());
	}

}