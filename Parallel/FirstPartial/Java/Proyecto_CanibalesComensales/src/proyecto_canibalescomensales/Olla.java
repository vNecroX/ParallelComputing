
package proyecto_canibalescomensales;

public class Olla 
{
    int capacidad = 6;
    
    public void agarrar()
    {
        capacidad--;
        System.out.println("Capacidad: " + capacidad);
        //semaforoCapacidad
    }
    
    public void llenar()
    {
        capacidad++;
    }
    
    public int checar()
    {
        return capacidad;
    }
    
    
    
}
