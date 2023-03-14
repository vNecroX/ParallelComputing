package practica4_productorconsumidor__20110388;

import static practica4_productorconsumidor__20110388.Practica4_ProductorConsumidor__20110388.newClients;

public class Provider extends Thread{
    public void fillStore(){
        if(!StoreStatus.fullFlag){
            StoreStatus.products = 10;
            StoreStatus.fullFlag = true;
            System.out.println(">>>>La cantidad de productos se ha reestablecido a 10!<<<<\n");
        }
    }
    
    @Override
    public void run(){
        try{
            fillStore();
            newClients();
        }catch(Exception ex){ System.out.println(ex); }
    }
}
