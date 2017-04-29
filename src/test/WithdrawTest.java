package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Purse;
import coinpurse.Valuable;
import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;

public class WithdrawTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	private static Purse purse;

	/**
	 * Sets up the test fixture. Called before every test case method.
	 */
	@Before
	public void setUp() {
		purse = new Purse(5);
		purse.setWithdrawStrategy(new RecursiveWithdraw());
	}

	@Test
	public void withdrawEmptyPurseTest() {
		assertNull(purse.withdraw(20));
		assertNull(purse.withdraw(1));
	}

	@Test
	public void simpleWithdrawTest() {
		purse.insert(new Coin(5));
		Valuable[] expect1 = { new Coin(5) };
		assertArrayEquals(expect1, purse.withdraw(5));
		assertEquals(0, purse.getBalance(), TOL);
		purse.insert(new BankNote(20));
		Valuable[] expect2 = { new BankNote(20) };
		assertArrayEquals(expect2, purse.withdraw(20));
		assertEquals(0, purse.getBalance(), TOL);
	}

	@Test
	public void hardWithdrawTest() {
		purse.insert(new Coin(1));
		purse.insert(new BankNote(20));
		purse.insert(new Coin(10));
		Valuable[] expect1 = { new Coin(10), new Coin(1) };
		assertArrayEquals(expect1, purse.withdraw(11));
		assertEquals(20, purse.getBalance(), TOL);
		Valuable[] expect2 = { new BankNote(20) };
		assertArrayEquals(expect2, purse.withdraw(20));
		assertEquals(0, purse.getBalance(), TOL);
	}
}
