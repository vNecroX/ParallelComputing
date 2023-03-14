
package proyecto_canibalescomensales;

import java.util.Random;

public class Canibal extends Thread
{
    String name;
    Cocinero cocinero;
    
    public Canibal(String name, Cocinero cocinero)
    {
        this.name = name;
        this.cocinero = cocinero;
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try 
            {
                sleep(2500 + new Random().nextInt(8000) + new Random().nextInt(8000));
                
                System.out.println("Canibal " + name + " va agarrar comida");

                if(Cueva.semaforoCapacidad.availablePermits() == 0 && cocinero.estado == "descansando")
                {
                    cocinero.avisar();
                }

                Cueva.semaforoCapacidad.acquire();

                Cueva.semaforoCandado.acquire();

                Cueva.olla.agarrar();

                System.out.println("Canibal " + name + " agarro comida");

                Cueva.semaforoCandado.release();

            } 
            catch (InterruptedException ex) 
            {
                System.out.println(ex);
            }
        }
    }
    
}
