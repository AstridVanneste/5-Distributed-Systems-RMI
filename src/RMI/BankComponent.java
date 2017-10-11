package RMI;

import static sun.swing.MenuItemLayoutHelper.max;

public class BankComponent extends GenericComponent
{
	private static final int THRESHOLD = -200;
	private int balance = 0;

	/**
	 *
	 */
	public BankComponent ()
	{
		super(ComponentKeys.BANK_KEY);
		this.balance = 0;
	}

	/**
	 *
	 * @param initialBalance
	 */
	public BankComponent (int initialBalance)
	{
		super(ComponentKeys.BANK_KEY);
		this.balance = initialBalance;
	}

	/**
	 *
	 * @return
	 */
	public int getBalance ()
	{
		return this.balance;
	}

	/**
	 *
	 * @param amount
	 */
	public void deposit (int amount)
	{
		if ((this.balance + amount) < this.balance)
		{
			this.balance = Integer.MAX_VALUE;
		}
		else
		{
			this.balance += amount;
		}
	}

	/**
	 *
	 * @param amount
	 */
	public void withdraw (int amount)
	{
		if ((this.balance - amount) > THRESHOLD)
		{
			this.balance -= amount;
		}
		else
		{
			this.balance = THRESHOLD;
		}
	}
}
