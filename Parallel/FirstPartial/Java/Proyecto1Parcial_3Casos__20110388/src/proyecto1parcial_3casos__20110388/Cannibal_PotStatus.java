package proyecto1parcial_3casos__20110388;

import java.util.concurrent.Semaphore;

public class Cannibal_PotStatus{
    static Semaphore sCapacity;
    static Semaphore sLock;
    
    static int capacity = 8;
    
    public static void takeFood(){
        capacity--;
        System.out.println(">>>> Capacidad de la olla: " + capacity + " <<<<");
    }
    
    public static void fillPot(){ capacity++; }
}
