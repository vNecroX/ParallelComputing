package proyecto3parcial_clasificadorparimparrmi__20110388;

import static proyecto3parcial_clasificadorparimparrmi__20110388.ClientR.stringArray;

public class StringConverter{
    public void arrayToString(int [] arr, int s){
        for(int i=0; i<s; i++){
            stringArray += Integer.toString(arr[i]);
            
            if(i+1 != s)
                stringArray += ", ";
        }
        
        System.out.println(stringArray);
    }
}
