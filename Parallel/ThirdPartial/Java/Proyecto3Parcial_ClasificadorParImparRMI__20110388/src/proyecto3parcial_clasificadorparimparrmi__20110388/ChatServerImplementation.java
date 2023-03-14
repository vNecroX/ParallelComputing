package proyecto3parcial_clasificadorparimparrmi__20110388;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServerImplementation extends UnicastRemoteObject implements ServerChat{
    public ArrayList<ClientChat> clients;
    
    int evenOrOdd; int source; int [] array; int sizeArray;
    int [] evenArray; int sizeEvenArray;
    int [] oddArray; int sizeOddArray;
    
    SequentialMethod sequntialMethod;
    
    public ChatServerImplementation() throws RemoteException{
       clients = new ArrayList<>(); 
    }
    
    @Override
    public void registerClient(ClientChat client) throws RemoteException{
        this.clients.add(client);
        System.out.println("Cliente creado!");
    }
    
    @Override
    public void initClientParameters(int evenOrOdd, int source, int [] array, int sizeArray) throws RemoteException{
        this.evenOrOdd = evenOrOdd;
        this.source = source;
        this.array = array;
        this.sizeArray = sizeArray;
    }

    @Override
    public void initProcedure() throws RemoteException{
        
        if((evenOrOdd == 0) && (source == 1)){
            System.out.println("Server recibe evenOrOdd: " + evenOrOdd + ", " + "source: " + source);
            
            for(int i=0; i<sizeArray; i++)
                System.out.print(array[i] + ", ");
                
            sequntialMethod = new SequentialMethod(array, sizeArray, evenOrOdd);
            sequntialMethod.extractNumbers();
        }
    }
}
