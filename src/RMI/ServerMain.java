package RMI;

import java.rmi.RemoteException;

/**
 * Created by Astrid on 11-Oct-17.
 */
public class ServerMain
{
	public static void main(String[] args)
	{
		Server server = new Server();

		server.init();

		BankComponent bank = new BankComponent(200);

		server.addComponent(ComponentKeys.BANK_KEY,bank);
		try
		{
			BankComponent bc = (BankComponent) server.getComponent(ComponentKeys.BANK_KEY);
			System.out.println(bc.getBalance());
		}
		catch(RemoteException re)
		{
			re.printStackTrace();
		}

		System.out.println("BANK ADDED");
	}
}
