
package proyecto_canibalescomensales;

public class Cocinero extends Thread
{
    public String estado;
    
    public Cocinero()
    {
        estado = "descansando";
    }
    
    public void avisar()
    {
        estado = "cocinando";
    }
    
    public void cocinar()
    {
        System.out.println("Cocinero: empieza a cocinar");
        
        int i = 0;
                
        while(i < 6)
        {
            try 
            {
                sleep(1000);
                Cueva.olla.llenar();
                System.out.println("Llenando la olla... " + (i+1));
                i++;
            } 
            catch (InterruptedException ex) 
            {
                System.out.println(ex);
            }
        }
        
        Cueva.semaforoCapacidad.release(6);
        
        estado = "descansando";
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try 
            {
                if(estado == "cocinando")
                {
                    cocinar();
                }
                else
                {
                    // esta descansando
                }
                
                sleep(400);
            } 
            catch (InterruptedException ex) 
            {
                
            }
        }
    }
    
    
}
