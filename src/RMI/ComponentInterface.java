package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComponentInterface extends Remote
{
	public GenericComponent getComponent (String key) throws RemoteException;
}
