
package practica1_chatrmi__20110388;

import java.util.Scanner;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ChatClientImplementation extends UnicastRemoteObject implements ClientChat, Runnable {
    ServerChat server;
    public String name = null;
    
    public ChatClientImplementation(String name, ServerChat server) throws RemoteException{
        this.name = name;
        this.server = server;
        server.register(this);
    }
    
    @Override
    public String messageClient(String message) throws RemoteException{
        System.out.println(message);
        return message;
    }

    @Override
    public void messageServer(String message) throws RemoteException {
        System.out.println(message);
    }
    
    @Override
    public void run(){
        Scanner s = new Scanner(System.in);
        String message;
        
        while(true){
            message = s.nextLine();
            
            try{ server.message(name + " : " + message);}
            catch(Exception e) { e.printStackTrace(); }
        }
    }
}
