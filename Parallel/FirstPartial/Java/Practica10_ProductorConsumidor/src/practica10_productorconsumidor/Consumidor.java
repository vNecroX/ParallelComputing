package practica10_productorconsumidor;

import static java.lang.Thread.sleep;
import java.util.Random;

public class Consumidor extends Thread{
    String numeroCliente;
    
    public Consumidor(String _numeroCliente){
        this.numeroCliente = _numeroCliente;
    }
    
    @Override
    public void run(){
        while(EstadoTienda.banderaLleno){
            try{
                sleep(2000 + new Random().nextInt(500));
                System.out.println("Productos disponbles >>>> " + EstadoTienda.productos);
                System.out.println(numeroCliente + " ha consumido un producto!\n");
                EstadoTienda.productos--;

                if(EstadoTienda.productos == 0)
                    EstadoTienda.banderaLleno = false;
                
            }catch(Exception ex){ System.out.println(ex); }
        }
        
        System.out.println("|| Ya no hay mas productos disponibles, llamando al productor! ||");
        
        Productor productor = new Productor();
        productor.start();
    }
}
