package proyecto1parcial_3casos__20110388;

import static java.lang.Thread.sleep;

public class Cannibal_Chef extends Thread{
    public String status;
    
    public Cannibal_Chef(){
        status = "Descansando";
    }
    
    public void warn(){ status = "Cocinando"; }
    
    public void toCook(){
        System.out.println(">>>> El cocinero ha empezado a trabajar! <<<<");
        
        int i = 0;
                
        while(i < 8){
            try{
                sleep(1000);
                Cannibal_PotStatus.fillPot();
                System.out.println("La olla se esta llenando de comida!: " + (i+1));
                i++;
            } 
            catch(InterruptedException ex){ System.out.println(ex); }
        }
        
        Cannibal_PotStatus.sCapacity.release(8);
        status = "Descansando";
    }
    
    @Override
    public void run(){
        while(true){
            try{
                if("Cocinando".equals(status))
                    toCook();
                
                sleep(400);
            } 
            catch(InterruptedException ex){ System.out.println(ex); }
        }
    }
}
