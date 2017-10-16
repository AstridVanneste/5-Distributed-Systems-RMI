package RMI;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface ServerInterface extends Remote
{
	public int getBalance () throws RemoteException;

	public void deposit (int amount) throws RemoteException;

	public void withdraw (int amount) throws RemoteException;
}
