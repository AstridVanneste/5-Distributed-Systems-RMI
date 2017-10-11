package RMI;

import static sun.swing.MenuItemLayoutHelper.max;

public class BankComponent extends GenericComponent
{
	private int balance = 0;

	public BankComponent ()
	{
		super(ComponentKeys.BANK_KEY);
		this.balance = 0;
	}

	public BankComponent (int initialBalance)
	{
		super(ComponentKeys.BANK_KEY);
		this.balance = initialBalance;
	}

	public int getBalance ()
	{
		return this.balance;
	}

	public void deposit (int amount)
	{
		if ((Math.abs(Integer.MAX_VALUE) - Math.abs(this.balance)) < Math.abs(amount))
		{
			this.balance = Integer.MAX_VALUE;
		}
		else
		{
			this.balance += Math.abs(amount);
		}
	}

	/**
	 * @param amount
	 */
	public void withdraw (int amount)
	{
		if ((Math.abs(Math.abs(Integer.MIN_VALUE) - Math.abs(this.balance))) < Math.abs(amount))
		{
			this.balance = Integer.MIN_VALUE;
		}
		else
		{
			this.balance -= Math.abs(amount);
		}
	}
}
