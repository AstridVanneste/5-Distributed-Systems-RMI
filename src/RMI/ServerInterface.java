package RMI;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface ServerInterface extends Remote
{
	public GenericComponent getComponent (String key) throws RemoteException;

	public Set<String> getComponentKeys() throws RemoteException;

	public int getNumberComponents() throws RemoteException;
}
