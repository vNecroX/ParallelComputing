package practica1_chatrmi__20110388;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class ClientRMI{

    public static void main(String[] args){
        try{
            String name = JOptionPane.showInputDialog("Ingresa tu nombre");
            Registry rmi = LocateRegistry.getRegistry("localhost", 1005);
            ServerChat server = (ServerChat) rmi.lookup("Chat");
            
            new Thread(new ChatClientImplementation(name, server)).start();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
