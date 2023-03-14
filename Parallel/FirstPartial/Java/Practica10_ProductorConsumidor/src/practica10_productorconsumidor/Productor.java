package practica10_productorconsumidor;

import static practica10_productorconsumidor.Practica10_ProductorConsumidor.nuevosConsumidores;

public class Productor extends Thread{
    public void rellenarTienda(){
        if(!EstadoTienda.banderaLleno){
            EstadoTienda.productos = 20;
            EstadoTienda.banderaLleno = true;
            System.out.println("|| La tienda ha reestablecido sus productos a 20! ||\n");
        }
    }
    
    @Override
    public void run(){
        try{
            rellenarTienda();
            nuevosConsumidores();
        }catch(Exception ex){ System.out.println(ex); }
    }
}
