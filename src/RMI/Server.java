package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
/**
 * Created by Astrid on 11-Oct-17.
 */
public class Server implements ServerInterface
{
	private static final int THRESHOLD = -200;
	public static final String SERVER_NAME = "Server";

	private int balance;

	public Server()
	{
		this.balance = 0;
	}

	public void init ()
	{
		if(System.getSecurityManager()==null)
		{
			System.setSecurityManager(new SecurityManager());
		}

		try
		{
			ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(this,0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind(Server.SERVER_NAME, stub);
		}
		catch(RemoteException re)
		{
			System.err.println("Exception when creating stub");
			re.printStackTrace();
		}
	}

	@Override
	public int getBalance()
	{
		return this.balance;
	}

	@Override
	public void deposit(int amount)
	{
		synchronized ((Integer) amount)
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
	}

	@Override
	public void withdraw(int amount)
	{
		synchronized ((Integer) amount)
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
}
