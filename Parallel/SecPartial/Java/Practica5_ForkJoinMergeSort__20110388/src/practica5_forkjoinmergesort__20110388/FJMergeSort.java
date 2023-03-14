package practica5_forkjoinmergesort__20110388;

import java.util.concurrent.RecursiveAction;

public class FJMergeSort extends RecursiveAction{
    private final int[] arr;
    private final int l;
    private final int r;
    
    public FJMergeSort(int[] arr, int l, int r){
        this.arr = arr;
        this.l = l;
        this.r = r;
    }
    
    @Override
    protected void compute() {
        if(l < r){
            int m = l + (r-l)/2;
  
            FJMergeSort left = new FJMergeSort(arr, l, m);
            FJMergeSort right = new FJMergeSort(arr, m + 1, r);
            invokeAll(left, right);
            merge(arr, l, m, r);
        }
        else
            return;
    }
    
    void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
  
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        for(int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for(int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        int i = 0, j = 0;
  
        int k = l;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
  
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
