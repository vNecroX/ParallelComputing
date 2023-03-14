
package practica3_interfazgrafica;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class MergeSortForkJoin extends RecursiveAction
{
    private int[] array;
    private int n;
    
    public MergeSortForkJoin(int[] array)
    {
        this.array = array;
        this.n = array.length;
    }
    
    public void calc()  
    {
        ForkJoinTask task = new MergeSortForkJoin(array);
        new ForkJoinPool().invoke(task);
    }
    
    public void merge(int[] array, int[] leftArray, int[] rightArray, int numLeft, int numRight) 
    {
        int i = 0, j = 0, k = 0;
        
        while (i<numLeft && j<numRight)
        {
            if (leftArray[i] <= rightArray[j]) 
                array[k++] = leftArray[i++];
            else 
                array[k++] = rightArray[j++];
        }
        
        while (i < numLeft) 
            array[k++] = leftArray[i++];
        
        while (j < numRight) 
            array[k++] = rightArray[j++];
    }
    
    @Override
    public void compute() 
    {
        if (n<2) 
            return;
        
        int middle = n/2;

        int[] left = new int[middle];
        System.arraycopy(array, 0, left, 0, middle);

        int[] right = new int[n-middle];
        System.arraycopy(array, middle, right, 0, n-middle);

        invokeAll(new MergeSortForkJoin(left), new MergeSortForkJoin(right));
        
        merge(array, left, right, middle, n-middle);
    }
    
    
}
