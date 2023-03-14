package proyecto3parcial_clasificadorparimparrmi__20110388;

import java.rmi.RemoteException;

public class SequentialMethod{
    
    int [] arr; int size; int evenOrOdd; 
    int [] newArr = new int[100]; int newSizeArray = 0;
    
    StringConverter stringConverter;
    
    public SequentialMethod(int [] arr, int size, int evenOrOdd){
        this.arr = arr;
        this.size = size;
        this.evenOrOdd = evenOrOdd;
    }
    
    public void extractNumbers() throws RemoteException{
        System.out.println();
                
        if(evenOrOdd == 0){
            for(int i=0; i<size; i++){
                if(arr[i] % 2 == 0){
                    newArr[newSizeArray] = arr[i];
                    System.out.print(newArr[newSizeArray] + ", ");
                    newSizeArray++;
                }
            }
        }
        else{
            for(int i=0; i<size; i++){
                if(arr[i] % 2 != 0){
                    newArr[newSizeArray] = arr[i];
                    newSizeArray++;
                }
            }
        }
        
        stringConverter.arrayToString(newArr, newSizeArray);
    }
}
