import RMI.BankComponent;

public class BankTest
{
	public static void main (String[] args)
	{
		BankComponent account1 = new BankComponent();
		BankComponent account2 = new BankComponent(500);

		System.out.println("Account1: " + Integer.toString(account1.getBalance()) + "\nAccount2: " + Integer.toString(account2.getBalance()));

		account1.withdraw(500);
		account2.withdraw(500);

		System.out.println("Account1: " + Integer.toString(account1.getBalance()) + "\nAccount2: " + Integer.toString(account2.getBalance()));
	}
}
