
package practica3_interfazgrafica;

import java.time.Duration;
import java.time.Instant;

public class Recorder 
{
    private static Instant start;
    private static Instant end;
    
    public static void start()
    {
        start = Instant.now();
    }
    
    public static void stop()
    {
        end = Instant.now();
    }
    
    public static String get()
    {
        Duration timeElapsed = Duration.between(start, end);
        return timeElapsed.toMillis() + "";
    }
    
}
