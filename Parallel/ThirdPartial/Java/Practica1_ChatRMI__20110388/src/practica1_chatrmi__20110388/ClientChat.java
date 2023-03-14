package practica1_chatrmi__20110388;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientChat extends Remote
{
    String messageClient(String message) throws RemoteException;
    void messageServer(String message) throws RemoteException;
}
