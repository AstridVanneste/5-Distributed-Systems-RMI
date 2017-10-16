package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Astrid on 11-Oct-17.
 */
public class Server implements ServerInterface
{
	public static final String SERVER_NAME = "Server";
	private HashMap<String,GenericComponent> components;

	public Server()
	{
		this.components = new HashMap<>();
	}

	public void init ()
	{
		if(System.getSecurityManager()==null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		try
		{
			ServerInterface server = new Server();
			ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(server,0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind(Server.SERVER_NAME, stub);
			System.out.println("Server bound");
		}
		catch(RemoteException re)
		{
			System.err.println("Exception when creating stub");
			re.printStackTrace();
		}
	}

	@Override
	public GenericComponent getComponent(String key) throws RemoteException
	{
		System.out.println("Component being accessed");
		if(components.containsKey(key))
		{
			return components.get(key);
		}
		else
		{
			throw new RuntimeException("No Component with that key");
		}
	}

	@Override
	public Set<String> getComponentKeys() throws RemoteException
	{
		return components.keySet();
	}

	@Override
	public int getNumberComponents() throws RemoteException
	{
		return components.size();
	}

	public void addComponent(String key, GenericComponent component)
	{
		components.put(key, component);

	}
}
