package practica10_productorconsumidor;

import java.util.Random;

public class Practica10_ProductorConsumidor extends Thread{
    static Consumidor [] consumidores = new Consumidor[20];
    
    public static void main(String[] args){
        Practica10_ProductorConsumidor.nuevosConsumidores();
    }
    
    public static void nuevosConsumidores(){
        Random rand = new Random();
        int j = rand.nextInt(15-1) + 1;
        
        for(int i=0; i<j; i++)
            consumidores[i] = new Consumidor("Consumidor[" + i + "]");
        
        for(int i=0; i<j; i++)
            consumidores[i].start();
    }
}
