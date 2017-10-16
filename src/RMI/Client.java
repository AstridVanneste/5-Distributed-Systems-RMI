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
			Registry registry1 = LocateRegistry.getRegistry("127.0.0.1");
			ServerInterface server1 = (ServerInterface) registry1.lookup(Server.SERVER_NAME);

			System.out.println("Balance: € " + Integer.toString(server1.getBalance()));
			System.out.println("Depositing €200");
			server1.deposit(200);
			System.out.println("Balance: € " + Integer.toString(server1.getBalance()));
			System.out.println("Withdrawing €50");
			server1.withdraw(50);
			System.out.println("Balance: € " + Integer.toString(server1.getBalance()));

			Registry registry2 = LocateRegistry.getRegistry("127.0.0.1");
			ServerInterface server2 = (ServerInterface) registry1.lookup(Server.SERVER_NAME);

			System.out.println("Refreshed Server...");
			System.out.println("Balance: € " + Integer.toString(server1.getBalance()));
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
