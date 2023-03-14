
package proyecto_canibalescomensales;

import java.util.concurrent.Semaphore;

public class Cueva 
{
    public static Semaphore semaforoCapacidad;
    public static Semaphore semaforoCandado;
    
    public static Olla olla;
    
    public Cueva()
    {
        semaforoCapacidad = new Semaphore(6, true);
        semaforoCandado = new Semaphore(1, true);
        olla = new Olla();
    }
    
    public void iniciar()
    {
        Cocinero cocinero = new Cocinero();
        
        cocinero.start();
        
        int i=0;
        
        while(i < 4)
        {
            new Canibal("Canibal "+(i+1), cocinero).start();
            i++;
        }
    }
    
}
