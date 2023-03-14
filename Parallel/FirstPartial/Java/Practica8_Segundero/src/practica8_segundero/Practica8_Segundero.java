package practica8_segundero;

import static java.lang.Thread.sleep;
import java.util.Random;

public class Practica8_Segundero extends Thread{
    int segundos = 0;
    int minutos = 0;
    int horas = 0;
    
    String seg;
    String min;
    String hor;

    public static void main(String[] args){
        Practica8_Segundero hilo = new Practica8_Segundero();
        hilo.start();
    }
    
    @Override
    public void run(){
        while(true){
            try{
                if(horas < 10)
                    hor = 0 + Integer.toString(horas);
                else
                    hor = Integer.toString(horas);
                
                if(minutos < 10)
                    min = 0 + Integer.toString(minutos);
                else
                    min = Integer.toString(minutos);
                
                if(segundos < 10)
                    seg = 0 + Integer.toString(segundos);
                else
                    seg = Integer.toString(segundos);
                
                System.out.println(hor + ":" + min + ":" + seg);
                sleep(1000);
                segundos++;
                
                if(segundos == 60){
                    segundos = 0;
                    minutos++;
                }
                
                if(minutos == 60){
                    minutos = 0;
                    horas++;
                }
            }
            catch(Exception ex){ System.out.println(ex); }
        }
    }
}
