package proyecto1parcial_3casos__20110388;

import static java.lang.Thread.sleep;
import java.util.Random;

public class Cannibal_Cannibal extends Thread{
    String name;
    Cannibal_Chef chef;
    
    public Cannibal_Cannibal(String name, Cannibal_Chef _chef){
        this.name = name;
        this.chef = _chef;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                sleep(2500 + new Random().nextInt(8000) + new Random().nextInt(8000));
                
                System.out.println(name + " va agarrar comida!");

                if(Cannibal_PotStatus.sCapacity.availablePermits() == 0 && "Descansando".equals(chef.status))
                    chef.warn();

                Cannibal_PotStatus.sCapacity.acquire();
                Cannibal_PotStatus.sLock.acquire();
                Cannibal_PotStatus.takeFood();

                System.out.println(name + " agarro comida!\n");
                Cannibal_PotStatus.sLock.release();

            } 
            catch (InterruptedException ex){ System.out.println(ex); }
        }
    }
}
