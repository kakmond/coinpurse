package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Valuable utility methods for practice using Lists and Comparator.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class CoinUtil {

	/**
	 * Method that examines all the valuable in a List and returns only the valuable
	 * that have a currency that matches the parameter value.
	 * 
	 * @param valuablelist is a List of Valuable objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from valuablelist that have
	 *         the requested currency.
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> valuablelist, String currency) {
		List<Valuable> newList = new ArrayList<Valuable>();
		for (Valuable valuable : valuablelist) {
			if (valuable.getCurrency().equals(currency))
				newList.add(valuable);
		}
		return newList;
	}

	/**
	 * Method to sort a list of Valuable by currency. On return, the list (Valuable)
	 * will be ordered by currency.
	 * 
	 * @param valuable is a List of Coin objects we want to sort.
	 *
	 */
	public static void sortByCurrency(List<Valuable> valuable) {
		Collections.sort(valuable, new CompareByCurrency());
	}

	/**
	 * Sum money by currency and print the sum for each currency. Print one line
	 * for the sum of each currency.
	 * 
	 * @param valuable is List of Valuable objects
	 */
	public static void sumByCurrency(List<Valuable> valuable) {
		Map<String, Double> sumByMap = new HashMap<String, Double>();
		for (Valuable v : valuable) {
			if (sumByMap.containsKey(v.getCurrency())) {
				sumByMap.put(v.getCurrency(), v.getValue() + sumByMap.get(v.getCurrency()));
			} else {
				sumByMap.put(v.getCurrency(), v.getValue());
			}
		}

		for (String key : sumByMap.keySet()) {
			double value = sumByMap.get(key);
			System.out.println(value + " " + key );
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (coins.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		sortByCurrency(coins);
		System.out.print("RESULT: ");
		printList(coins, " ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= ");
		printList(coins, " ");
		sumByCurrency(coins);

	}

	/**
	 * Make a list of Valuable containing different currencies.
	 * 
	 * @return the List of Valuable objects
	 */
	public static List<Valuable> makeInternationalCoins() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/**
	 * Make a list of Valuable using given values.
	 * 
	 * @param currency is the currency of the Valuable
	 * @param values is the value of Valuable
	 * @return the List of Valuable object
	 */
	public static List<Valuable> makeCoins(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/**
	 * Print the list on the console, on one line.
	 * 
	 * @param items is the List of items that you want to print
	 * @param separator is String that you want to separate with
	 */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println();
	}

}