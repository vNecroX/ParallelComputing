package practica2_prioridadhilos__20110388;

public class Practica2_PrioridadHilos__20110388 extends Thread{

    @Override
    public void run(){
        System.out.print("Hilo actual es: "+Thread.currentThread().getName());
        System.out.println();
    }
    
    public static void main(String[] args) {
        Practica2_PrioridadHilos__20110388 thread1 = new Practica2_PrioridadHilos__20110388();
        Practica2_PrioridadHilos__20110388 thread2 = new Practica2_PrioridadHilos__20110388();
        Practica2_PrioridadHilos__20110388 thread3 = new Practica2_PrioridadHilos__20110388();
        
        Name name1 = new Name("Hilo1");
        thread1.setName(name1.name);
        thread1.setPriority(Thread.MIN_PRIORITY);
        
        Name name2 = new Name("Hilo2");
        thread2.setName(name2.name);
        thread2.setPriority(Thread.NORM_PRIORITY);
        
        Name name3 = new Name("Hilo3");
        thread3.setName(name3.name);
        thread3.setPriority(Thread.MAX_PRIORITY);
  
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
