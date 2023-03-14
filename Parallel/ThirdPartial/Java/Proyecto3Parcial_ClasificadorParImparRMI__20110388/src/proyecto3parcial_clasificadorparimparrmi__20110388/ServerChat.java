
package proyecto3parcial_clasificadorparimparrmi__20110388;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerChat extends Remote{
    void registerClient(ClientChat client) throws RemoteException;
    void initClientParameters(int evenOrOdd, int source, int [] array, int sizeArray) throws RemoteException;
    void initProcedure() throws RemoteException;
}
