package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Astrid on 11-Oct-17.
 * https://docs.oracle.com/javase/tutorial/rmi/overview.html
 */
public class Client
{
	public static void main(String[] args)
	{
		if(System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		try
		{
			Registry registry = LocateRegistry.getRegistry("127.0.0.1");
			ServerInterface server = (ServerInterface) registry.lookup(Server.SERVER_NAME);
			System.out.println("Number of components in server " + server.getNumberComponents());

			BankComponent bank = (BankComponent) server.getComponent(ComponentKeys.BANK_KEY);


			System.out.println("Balance: " + bank.getBalance());

		}
		catch(RemoteException re)
		{
			System.err.println("Exception when creating registry");
			re.printStackTrace();
		}
		catch(NotBoundException nbo)
		{
			System.err.println("Exception when looking up server");
			nbo.printStackTrace();
		}
	}
}
