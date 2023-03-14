package practica9_carrera;

import static java.lang.Thread.sleep;
import java.util.Random;

public class EstadoAnimal extends Thread{
    String nombre;
    int velocidad;
    int metros;
    
    public EstadoAnimal(String nombre, int velocidad){
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.metros = 0;
    }
    
    @Override
    public void run(){
        System.out.println("Con una velocidad de: " + velocidad + "mts/s, echa a correr el " + nombre + "!");
        
        while(metros <= EstadoCarrera.meta){
            try{
                sleep(500 + new Random().nextInt(500));
                System.out.println(nombre + " >>>> " + metros);
            }catch(Exception ex){ System.out.println(ex); }
            
            metros += velocidad;
        }
        
        System.out.println("|| El " + nombre + " ha llegado en " + EstadoCarrera.posicionAnimal + " lugar, recorriendo un total de: " + metros + "mts ||");
        EstadoCarrera.posicionAnimal++;
    }
}
