package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Astrid on 11-Oct-17.
 */
public class Server implements ComponentInterface
{
	private HashMap<String,GenericComponent> components;

	public Server()
	{
		components = new HashMap<>();
	}

	@Override
	public GenericComponent getComponent(String key) throws RemoteException
	{
		return components.get(key);
	}

	@Override
	public Set<String> getComponentKeys() throws RemoteException
	{
		return components.keySet();
	}

	public static void main(String[] args)
	{
		if(System.getSecurityManager()==null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		try
		{
			String name = "Server";
			ComponentInterface server = new Server();
			ComponentInterface stub = (ComponentInterface) UnicastRemoteObject.exportObject(server,0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name,stub);
			System.out.println("Server bound");
		}
		catch(RemoteException re)
		{
			System.err.println("Exception when creating stub");
			re.printStackTrace();
		}
	}
}
