package proyecto1parcial_3casos__20110388;

import static java.lang.Thread.sleep;
import java.util.Random;
import static proyecto1parcial_3casos__20110388.Proyecto1Parcial_3Casos__20110388.caseBridge;

public class Bridge_North extends Thread{
    String idVehicle;
    
    public Bridge_North(String _idVehicle){
        this.idVehicle = _idVehicle;
    }
    
    @Override
    public void run(){
        while(Bridge_SubjectStatus.vehiclesFromNorth > 0){
            try{
                sleep(3500 + new Random().nextInt(500));
                System.out.println("Vehiculos transitando de norte a sur: " + Bridge_SubjectStatus.vehiclesFromNorth);
                System.out.println(idVehicle + " actualmente transitando!\n");
                    
                Bridge_SubjectStatus.vehiclesFromNorth--;
                
                if(Bridge_SubjectStatus.vehiclesFromNorth == 0){
                    Bridge_SubjectStatus.isBridgeFromNorthOccupied = false;
                    System.out.println(">>>> Ya no hay vehiculos por transitar de norte a sur! <<<<\n");
                }    
                
            }catch(InterruptedException ex){ System.out.println(ex); }
        }
        
        caseBridge();
    }
}
