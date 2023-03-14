
package practica3_interfazgrafica;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task implements Callable<Void> 
    {
        
//        private int left;
//        private int right;
        
        private int n;
        private int[] array;
        
        private ExecutorService executor = Executors.newCachedThreadPool();;
        
        

//        Task() 
//        {
//            left = 0;
//            right = array.length - 1;
//        }
//
//        private Task(int left, int right) 
//        {
//            this.left = left;
//            this.right = right;
//        }
        
//        Task() 
//        {
//            left = 0;
//            right = array.length - 1;
//        }

        public Task(int[] array) 
        {
            this.array = array;
            this.n = array.length;
        }

        @Override
        public Void call() throws Exception 
        {
            if (n<2)
                return null;
            
            int middle = n/2;
            
            
            int[] left = new int[middle];
            int[] right = new int[n-middle];

            for (int i=0; i<middle; i++) 
                left[i] = array[i];

            for (int i=middle; i<n; i++) 
                right[i-middle] = array[i];
            
            
            Future<Void> firstSubTask = executor.submit(new Task(left));
            Future<Void> secondSubtask = executor.submit(new Task(right));
            
            
            firstSubTask.get();
            secondSubtask.get();

            
            merge(array, left, right, middle, n-middle);
            
            return null;
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
