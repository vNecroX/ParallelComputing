
package practica3_interfazgrafica;
        
public class MergeSortSecuencial 
{
    int[] array;
    
    public MergeSortSecuencial(int[] array)
    {
        this.array = array;
    }
    
    public void calc()
    {
        mergeSort(array, array.length);
    }
    
    public void mergeSort(int[] array, int n) 
    {
        if (n<2)
            return;
        
        int middle = n/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[n-middle];

        for (int i=0; i<middle; i++) 
            leftArray[i] = array[i];
        
        for (int i=middle; i<n; i++) 
            rightArray[i-middle] = array[i];
        
        mergeSort(leftArray, middle);
        mergeSort(rightArray, n-middle);
        merge(array, leftArray, rightArray, middle, n-middle);
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
    
}
