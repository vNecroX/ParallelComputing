package proyecto1parcial_3casos__20110388;

import static java.lang.Thread.sleep;
import java.util.Random;
import static proyecto1parcial_3casos__20110388.Proyecto1Parcial_3Casos__20110388.caseBridge;
import static proyecto1parcial_3casos__20110388.Proyecto1Parcial_3Casos__20110388.caseBridgeNorth;
import static proyecto1parcial_3casos__20110388.Proyecto1Parcial_3Casos__20110388.caseBridgeSouth;

public class Bridge_South extends Thread{
    String idVehicle;
    
    public Bridge_South(String _idVehicle){
        this.idVehicle = _idVehicle;
    }
    
    @Override
    public void run(){
        while(Bridge_SubjectStatus.vehiclesFromSouth > 0){
            try{
                sleep(3500 + new Random().nextInt(500));
                System.out.println("Vehiculos transitando de sur a norte: " + Bridge_SubjectStatus.vehiclesFromSouth);
                System.out.println(idVehicle + " actualmente transitando!\n");
                
                Bridge_SubjectStatus.vehiclesFromSouth--;
                
                if(Bridge_SubjectStatus.vehiclesFromSouth == 0){
                    Bridge_SubjectStatus.isBridgeFromSouthOccupied = false;
                    System.out.println(">>>> Ya no hay vehiculos por transitar de sur a norte! <<<<\n");
                }
                
            }catch(InterruptedException ex){ System.out.println(ex); }
        }
        
        caseBridge();
    }
}
