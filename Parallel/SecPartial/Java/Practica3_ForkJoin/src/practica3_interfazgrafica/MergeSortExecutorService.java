
package practica3_interfazgrafica;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MergeSortExecutorService 
{
    private int[] array;
    
    private Duration duration;
    
    private ExecutorService executor;

    public MergeSortExecutorService(int[] array) 
    {
        this.array = array;
        executor = Executors.newCachedThreadPool();
    }


    public void calcular() 
    {
        try 
        {
            Instant start = Instant.now();
            Future<Void> first = executor.submit(new Task(array));
            first.get();
            Instant end = Instant.now();

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.DAYS);
            duration = Duration.between(start, end);
            
        } 
        catch (ExecutionException | InterruptedException e) 
        {
            System.out.println(e);
        }
    }

    
}



