package practica4_productorconsumidor__20110388;

import java.util.Random;

public class Practica4_ProductorConsumidor__20110388 extends Thread{
    static Client [] clients = new Client[10];
    
    public static void main(String[] args){
        Practica4_ProductorConsumidor__20110388.newClients();
    }
    
    public static void newClients(){
        Random rand = new Random();
        int j = rand.nextInt(8-1) + 1;
        
        for(int i=0; i<j; i++)
            clients[i] = new Client("Cliente_"+i);
        
        for(int i=0; i<j; i++)
            clients[i].start();
    }
}
