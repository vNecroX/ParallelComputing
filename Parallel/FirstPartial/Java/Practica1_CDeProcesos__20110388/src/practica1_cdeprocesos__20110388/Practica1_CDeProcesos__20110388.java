package practica1_cdeprocesos__20110388;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Practica1_CDeProcesos__20110388 {
    
    public static Integer [][] matrix = new Integer[3][3];
    
    public static void main(String[] args) {
        Practica1_CDeProcesos__20110388 mainObj;
        Random r = new Random(); 
        
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                matrix[i][j] = r.nextInt(20);
        
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                    System.out.print(matrix[i][j]+" ");
            System.out.println(" ");
        }
        
        System.out.println("\n");
        
        mainObj = new Practica1_CDeProcesos__20110388();
        mainObj.timesProc();
        
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                    System.out.print(matrix[i][j]+" ");
            System.out.println(" ");
        }
    }
    
    public void timesProc(){
        ArrayList<Thread> threads = new ArrayList<Thread>();
                
        List<Position> list = Arrays
                .asList(new Position(0,0), new Position(0,1), new Position(0,2), new Position(1,0), new Position(1,1));
        Thread thread1 = new Thread(new TimesThread(list, matrix));
        threads.add(thread1);
        thread1.start();
        
        list = Arrays
                .asList(new Position(1,2), new Position(2,0), new Position(2,1), new Position(2,2));
        Thread thread2 = new Thread(new TimesThread(list, matrix));
        threads.add(thread2);
        thread2.start();
        
        for(Thread thread : threads){
            try{ thread.join(); }
            catch(InterruptedException ex){ ex.printStackTrace(); }
        }
    }
}
