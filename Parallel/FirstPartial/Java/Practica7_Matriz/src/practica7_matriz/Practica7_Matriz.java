package practica7_matriz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Practica7_Matriz{

    public static Integer [][] matriz = new Integer[3][3];
    
    public static void main(String[] args){
        Practica7_Matriz objPrinc = new Practica7_Matriz();
        Random r = new Random(); 
        
        System.out.println("[Matriz inicial]:");
        
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                matriz[i][j] = r.nextInt(20);
        
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                    System.out.print(matriz[i][j]+" ");
            System.out.println(" ");
        }
        
        System.out.println("\n[Matriz final]:");
        
        objPrinc.procMultiplicar();
        
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                    System.out.print(matriz[i][j]+" ");
            System.out.println(" ");
        }
    }
    
    public void procMultiplicar(){
        ArrayList<Thread> threads = new ArrayList<Thread>();
                
        List<Posicion> list = Arrays
                .asList(new Posicion(0,0), new Posicion(0,1), new Posicion(0,2), new Posicion(1,0), new Posicion(1,1));
        Thread thread1 = new Thread(new MultHilo(list, matriz));
        threads.add(thread1);
        thread1.start();
        
        list = Arrays
                .asList(new Posicion(1,2), new Posicion(2,0), new Posicion(2,1), new Posicion(2,2));
        Thread thread2 = new Thread(new MultHilo(list, matriz));
        threads.add(thread2);
        thread2.start();
        
        for(Thread thread : threads){
            try{ thread.join(); }
            catch(InterruptedException ex){ ex.printStackTrace(); }
        }
    }
}
