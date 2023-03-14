package practica7_matriz;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MultHilo implements Runnable{
    private final ReentrantLock lock;
    private final List<Posicion> posList;
    private int i;
    private boolean finProc;
    private final Integer [][] matriz;
    
    public MultHilo(List<Posicion> posList, Integer[][] m){
        this.posList = posList;
        this.i = 0;
        this.lock = new ReentrantLock();
        this.finProc = false;
        this.matriz = m;
    }
    
    @Override
    public void run(){
        while(!this.finProc){
            criticalZone();
            noCriticalZone();
        }
    }
    
    public void criticalZone(){
        lock.lock();
        multiplyx2();
    }
    
    public void noCriticalZone(){ lock.unlock(); }
    
    public void multiplyx2(){
        try{
            Posicion pos = this.posList.get(this.i);
            matriz[pos.x][pos.y] *= 2;
            this.i++;
        }catch(Exception ex){ this.finProc = true; }
    }
}
