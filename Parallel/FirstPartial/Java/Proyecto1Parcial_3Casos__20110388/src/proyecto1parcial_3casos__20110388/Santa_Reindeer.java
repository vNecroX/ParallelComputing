package proyecto1parcial_3casos__20110388;

import static java.lang.Thread.sleep;
import java.util.Random;

public class Santa_Reindeer extends Thread{
    String idReindeer;
    
    public Santa_Reindeer(String _idReindeer){
        this.idReindeer = _idReindeer;
    }
    
    @Override
    public void run(){
        while(Santa_SubjectsStatus.reindeersInHome < 10){
            try{
                sleep(4000 + new Random().nextInt(500));
                System.out.println("Renos que han llegado: " + Santa_SubjectsStatus.reindeersInHome);
                System.out.println(idReindeer + " ha llegado!\n");
                
                if((Santa_SubjectsStatus.reindeersInHome == 9)){
                    Santa_SubjectsStatus.isSantaBusy = true;
                    System.out.println(">>>> Santa se va de viaje! <<<<\n");
                }
                
                if((Santa_SubjectsStatus.isSantaBusy) && (Santa_SubjectsStatus.goblinsInNeed == 3))
                    System.out.println(">>>> Duendes ocupan ayuda, pero Santa esta repartiendo juguetes! <<<<\n");
                
                Santa_SubjectsStatus.reindeersInHome++;
                    
            }catch(InterruptedException ex){ System.out.println(ex); }
        }
        
        System.out.println(">>>> Santa ha vuelto del viaje! <<<<\n");
        
        Santa_SubjectsStatus.reindeersInHome = 0;
        Santa_SubjectsStatus.isSantaBusy = false;
    }
}
