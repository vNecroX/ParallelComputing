package practica9_carrera;

public class Practica9_Carrera{

    
    public static void main(String[] args){
        EstadoAnimal estadoAnimal1 = new EstadoAnimal("Jaguar", 80);
        EstadoAnimal estadoAnimal2 = new EstadoAnimal("Leopardo", 58);
        EstadoAnimal estadoAnimal3 = new EstadoAnimal("Tigre", 65);
        
        estadoAnimal1.start();
        estadoAnimal2.start();
        estadoAnimal3.start();
    }
}
