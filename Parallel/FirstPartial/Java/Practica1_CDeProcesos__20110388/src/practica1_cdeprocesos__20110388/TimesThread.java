package practica1_cdeprocesos__20110388;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class TimesThread implements Runnable{
    
    private final ReentrantLock lock;
    private final List<Position> posList;
    private int index;
    private boolean procEnd;
    private final Integer [][] matrix;
    
    public TimesThread (List<Position> posList, Integer[][] m){
        this.posList = posList;
        this.index = 0;
        this.lock = new ReentrantLock();
        this.procEnd = false;
        this.matrix = m;
    }
    
    @Override
    public void run(){
        while(!this.procEnd){
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
            Position pos = this.posList.get(this.index);
            matrix[pos.x][pos.y] *= 2;
            this.index++;
        }catch(Exception ex){ this.procEnd = true; }
    }
}
