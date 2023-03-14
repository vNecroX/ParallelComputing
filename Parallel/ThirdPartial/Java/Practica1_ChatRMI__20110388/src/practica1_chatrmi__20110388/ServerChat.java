
package practica1_chatrmi__20110388;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerChat extends Remote
{
    void register(ClientChat client) throws RemoteException;
    void message(String message) throws RemoteException;
}
