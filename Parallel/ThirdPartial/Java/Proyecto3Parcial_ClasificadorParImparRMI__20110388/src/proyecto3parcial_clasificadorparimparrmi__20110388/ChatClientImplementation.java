package proyecto3parcial_clasificadorparimparrmi__20110388;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import static proyecto3parcial_clasificadorparimparrmi__20110388.ClientR.array;
import static proyecto3parcial_clasificadorparimparrmi__20110388.ClientR.evenOrOdd;
import static proyecto3parcial_clasificadorparimparrmi__20110388.ClientR.sizeArray;
import static proyecto3parcial_clasificadorparimparrmi__20110388.ClientR.source;

public class ChatClientImplementation extends UnicastRemoteObject implements Runnable, ClientChat{
    public String name;
    ServerChat server;
    
    int [] incomingArray; int incomingSizeArray;
    
    //SequentialMeth
    StringConverter stringConverter;
    
    public ChatClientImplementation(String name, ServerChat server) throws RemoteException{
        this.name = name;
        this.server = server;
        server.registerClient((ClientChat) this);
    }
    
    @Override
    public void run(){
        System.out.println("evenOrOdd: " + evenOrOdd + ", " + "source: " + source);
        try{ 
            server.initClientParameters(evenOrOdd, source, array, sizeArray); 
            server.initProcedure();
        }
        catch(Exception e){ e.printStackTrace(); }
    }

    
}
