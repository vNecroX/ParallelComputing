package practica4_productorconsumidor__20110388;

import static java.lang.Thread.sleep;
import java.util.Random;

public class Client extends Thread{
    String idClient;
    
    public Client(String _idClient){
        this.idClient = _idClient;
    }
    
    @Override
    public void run(){
        while(StoreStatus.fullFlag){
            try{
                sleep(2000 + new Random().nextInt(500));
                System.out.println("Productos disponbles: " + StoreStatus.products);
                System.out.println(idClient + " ha consumido un producto!\n");
                StoreStatus.products--;

                if(StoreStatus.products == 0)
                    StoreStatus.fullFlag = false;
                
            }catch(Exception ex){ System.out.println(ex); }
        }
        
        System.out.println(">>>> Productos agotados, llamando al proveedor!<<<<");
        
        Provider provider = new Provider();
        provider.start();
    }
}
