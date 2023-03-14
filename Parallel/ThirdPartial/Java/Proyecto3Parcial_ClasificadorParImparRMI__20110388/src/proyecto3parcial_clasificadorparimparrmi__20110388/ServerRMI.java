package proyecto3parcial_clasificadorparimparrmi__20110388;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI{
    
    public static void main(String[] args){
        try{
            Registry rmi = LocateRegistry.createRegistry(1005);
            rmi.rebind("Clasificador Par/Impar", (Remote) new ChatServerImplementation());
            System.out.println("Servidor activo!");
        }
        catch(Exception e){ e.printStackTrace(); }
    }
}