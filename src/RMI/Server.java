package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Astrid on 11-Oct-17.
 */
public class Server implements ComponentInterface
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
			ComponentInterface server = new Server();
			ComponentInterface stub = (ComponentInterface) UnicastRemoteObject.exportObject(server,0);
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
		return components.get(key);
	}

	@Override
	public Set<String> getComponentKeys() throws RemoteException
	{
		return components.keySet();
	}

	public void addComponent(String key, GenericComponent component)
	{
		components.put(key, component);
	}
}
