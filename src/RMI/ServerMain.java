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
	}
}
