package proyecto3parcial_clasificadorparimparrmi__20110388;

import java.util.concurrent.RecursiveAction;
import static proyecto3parcial_clasificadorparimparrmi__20110388.ClientR.evenArray;
import static proyecto3parcial_clasificadorparimparrmi__20110388.ClientR.oddArray;

public class FJMethod extends RecursiveAction{
    private final int[] arr;
    private final int s;
    private final int evenOrOdd;
    
    public FJMethod(int[] arr, int s, int evenOrOdd){
        this.arr = arr;
        this.s = s;
        this.evenOrOdd = evenOrOdd;
    }
    
    @Override
    protected void compute(){
        if(evenOrOdd == 0){
            for(int i=0, j=0; i<s; i++){
                if(arr[i] % 2 == 0){
                    evenArray[j] = arr[i];
                    j++;
                }
            }
        }
        else if(evenOrOdd == 1){
            for(int i=0, j=0; i<s; i++){
                if(arr[i] % 2 != 0){
                    oddArray[j] = arr[i];
                    j++;
                }
            }
        }
    }
}
