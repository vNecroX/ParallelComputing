package proyecto1parcial_3casos__20110388;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Proyecto1Parcial_3Casos__20110388{
    static Scanner keyboard = new Scanner(System.in);
    static int opt;
    
    static int i, j;
    static Random rand = new Random();
    
    static Santa_Goblin [] goblins = new Santa_Goblin[20]; static Santa_Reindeer [] reindeers = new Santa_Reindeer[20];
    static Bridge_North [] nVehicles = new Bridge_North[20]; static Bridge_South [] sVehicles = new Bridge_South[20];
    
    static Cannibal_PotStatus pot;
    static Cannibal_Cannibal [] cannibals = new Cannibal_Cannibal[20];
    
    public static void main(String[] args){
        Proyecto1Parcial_3Casos__20110388.printMenu();
        
        System.out.print("Opcion: ");
        opt = keyboard.nextInt();
        
        Proyecto1Parcial_3Casos__20110388.runOption(opt);
    }
    
    public static void printMenu(){
        System.out.println(">>>> Opcion 1: Santa.");
        System.out.println(">>>> Opcion 2: Puente.");
        System.out.println(">>>> Opcion 3: Canibales.\n");
    }
    
    public static void runOption(int o){
        System.out.println();
        
        switch(o){
            case 1 -> caseSanta();
            case 2 -> caseBridge();
            case 3 -> caseCannibal();
        }
    }
    
    public static void caseSanta(){
        for(i=0; i<9; i++){
            j = i + 1;
            
            goblins[i] = new Santa_Goblin("Duende_" + Integer.toString(j));
            reindeers[i] = new Santa_Reindeer("Reno_" + Integer.toString(j));
        }
        
        for(i=0; i<9; i++){
            goblins[i].start();
            reindeers[i].start();
        }
    }
    
    public static void caseBridge(){
        Bridge_SubjectStatus.vehiclesFromNorth = rand.nextInt(15-1) + 1;
        Bridge_SubjectStatus.vehiclesFromSouth = rand.nextInt(15-1) + 1;
        
        if(Bridge_SubjectStatus.vehiclesFromNorth >= Bridge_SubjectStatus.vehiclesFromSouth)
            caseBridgeNorth();
        else
            caseBridgeSouth();
    }
    
    public static void caseBridgeNorth(){
        for(i=0; i<Bridge_SubjectStatus.vehiclesFromNorth; i++){
            j = i + 1;
            nVehicles[i] = new Bridge_North("Vehiculo norte_" + Integer.toString(j));
        }
        
        if(!Bridge_SubjectStatus.isBridgeFromSouthOccupied){
            Bridge_SubjectStatus.isBridgeFromNorthOccupied = true;
            
            for(i=0; i<Bridge_SubjectStatus.vehiclesFromNorth; i++)
                nVehicles[i].start();
        }
    }
    
    public static void caseBridgeSouth(){
        for(i=0; i<Bridge_SubjectStatus.vehiclesFromSouth; i++){
            j = i + 1;
            sVehicles[i] = new Bridge_South("Vehiculo sur_" + Integer.toString(j));
        }
        
        if(!Bridge_SubjectStatus.isBridgeFromNorthOccupied){
            Bridge_SubjectStatus.isBridgeFromSouthOccupied = true;
            
            for(i=0; i<Bridge_SubjectStatus.vehiclesFromSouth; i++)
                sVehicles[i].start();
        }
    }
    
    public static void caseCannibal(){
        Cannibal_PotStatus.sCapacity = new Semaphore(8, true);
        Cannibal_PotStatus.sLock = new Semaphore(1, true);
        pot = new Cannibal_PotStatus();
        
        Cannibal_Chef chef = new Cannibal_Chef();
        chef.start();
        
        for(i=0; i<6; i++){
            j = i + 1;
            cannibals[i] = new Cannibal_Cannibal("Canibal_" + Integer.toString(j), chef);
        }
        
        for(i=0; i<6; i++)
            cannibals[i].start();
    }
}
