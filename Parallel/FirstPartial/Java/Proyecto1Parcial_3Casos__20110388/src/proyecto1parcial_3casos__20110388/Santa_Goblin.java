package proyecto1parcial_3casos__20110388;

import java.util.Random;

public class Santa_Goblin extends Thread{
    String idGoblin;
    
    public Santa_Goblin(String _idGoblin){
        this.idGoblin = _idGoblin;
    }
    
    @Override
    public void run(){
        while(Santa_SubjectsStatus.goblinsInNeed < 4){
            try{
                sleep(4000 + new Random().nextInt(500));
                System.out.println("Duendes que ocupan ayuda: " + Santa_SubjectsStatus.goblinsInNeed);
                System.out.println(idGoblin + " necesita ayuda!\n");
                
                Santa_SubjectsStatus.goblinsInNeed++;
                    
            }catch(InterruptedException ex){ System.out.println(ex); }
        }
        
        if(!Santa_SubjectsStatus.isSantaBusy){
            System.out.println(">>>> Santa puede ayudar a los duendes! <<<<\n");
            Santa_SubjectsStatus.goblinsInNeed = 0;
        }
    }
}
