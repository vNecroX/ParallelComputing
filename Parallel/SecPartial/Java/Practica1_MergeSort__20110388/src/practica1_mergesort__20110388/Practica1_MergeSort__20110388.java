package practica1_mergesort__20110388;

import java.util.Random;

public class Practica1_MergeSort__20110388{

    public static void main(String[] args){
        newArray();
    }
    
    public static void newArray(){
        Random rand = new Random();
        int size = rand.nextInt(40-10) + 10;
        int[] array = new int[size+10];
        
        System.out.println("Tamaño del arreglo: " + size);
        System.out.println("Elementos del arreglo: ");
        
        for(int i=0; i<size; i++)
            array[i] = rand.nextInt(100-1) + 1;
        
        printArray(array, size);
        
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, 0, size - 1);
        
        System.out.println("Elementos ordenados del arreglo: ");
        printArray(array, size);
    }
    
    public static void printArray(int arr[], int s){
        for (int i=0; i<s; i++){
            System.out.print(arr[i]);
            
            if(i+1 != s)
                System.out.print(", ");
            else
                System.out.println();
        }
    }
}
