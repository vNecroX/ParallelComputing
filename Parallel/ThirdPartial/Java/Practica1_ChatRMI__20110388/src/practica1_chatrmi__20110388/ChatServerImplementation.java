package practica1_chatrmi__20110388;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServerImplementation extends UnicastRemoteObject implements ServerChat{
    public ArrayList<ClientChat> clients;
    
    public ChatServerImplementation() throws RemoteException
    {
       clients = new ArrayList<>(); 
    }
    
    @Override
    public void register(ClientChat client) throws RemoteException{
        this.clients.add(client);
        System.out.println("Cliente creado!");
    }
    
    @Override
    public void message(String message) throws RemoteException{
        int a = 0;
        String s;
        
        while(a < clients.size()){
            s = clients.get(a++).messageClient(message);
            System.out.println("Cliente envio msj! " + s);
        }
    }
}
