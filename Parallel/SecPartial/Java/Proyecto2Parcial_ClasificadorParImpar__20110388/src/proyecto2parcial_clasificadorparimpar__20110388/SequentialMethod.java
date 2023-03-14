package proyecto2parcial_clasificadorparimpar__20110388;

import static proyecto2parcial_clasificadorparimpar__20110388.Proyecto2Parcial_ClasificadorParImpar__20110388.evenArray;
import static proyecto2parcial_clasificadorparimpar__20110388.Proyecto2Parcial_ClasificadorParImpar__20110388.oddArray;

public class SequentialMethod{
    void extractNumbers(int arr[], int size, int evenOrOdd){
        if(evenOrOdd == 0){
            for(int i=0, j=0; i<size; i++){
                if(arr[i] % 2 == 0){
                    evenArray[j] = arr[i];
                    j++;
                }
            }
        }
        else{
            for(int i=0, j=0; i<size; i++){
                if(arr[i] % 2 != 0){
                    oddArray[j] = arr[i];
                    j++;
                }
            }
        }
    }
}
