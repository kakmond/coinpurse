package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import coinpurse.strategy.*;

/**
 * A purse contains money. You can insert money, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the money
 * purse decides which money to remove.
 * 
 * @author Wongsathorn Panichkurkul
 */
public class Purse extends Observable {
	/** Collection of objects in the purse. */
	private List<Valuable> money = new ArrayList<Valuable>();
	/**
	 * Capacity is maximum number of money the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private WithdrawStrategy strategy = new GreedyWithdraw();

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of money that you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of money in the purse. This is the number of
	 * money, not their value.
	 * 
	 * @return the number of money in the purse
	 */
	public int count() {
		return this.money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for (Valuable valuable : money)
			balance += valuable.getValue();
		return balance;
	}

	/**
	 * Return the capacity of the purse.
	 * 
	 * @return the capacity.
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (this.count() >= this.capacity)
			return true;
		return false;
	}

	/**
	 * Insert a money into the purse. The money is only inserted if the purse
	 * has space for it and the money has positive value. No worthless money!
	 * 
	 * @param valuable is a Valuable object to insert into purse
	 * @return true if money inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		if (valuable.getValue() <= 0 || isFull())
			return false;
		money.add(valuable);
		super.setChanged();
		super.notifyObservers();
		return true;
	}

	/**
	 * Specify the strategy.
	 * 
	 * @param strategy is the strategy that you want to set to.
	 */
	public void setWithdrawStrategy(WithdrawStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount is the amount to withdraw.
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount >= 0) {
			List<Valuable> result = strategy.withdraw(amount, money);
			if (result != null) {
				for (Valuable v : result)
					this.money.remove(v);
				Valuable[] valuable = new Valuable[result.size()];
				result.toArray(valuable);
				super.setChanged();
				super.notifyObservers();
				return valuable;
			}
		}
		return null;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * 
	 * @return whatever is a useful description.
	 */
	public String toString() {
		return this.count() + " valuable with value " + this.getBalance();
	}

	/**
	 * Returns an unmodifiable view of the specified list.
	 * 
	 * @return an unmodifiable view of the specified list.
	 */
	public List<Valuable> listPurse() {
		return Collections.unmodifiableList(money);
	}

}
