package hw5.exmpls.;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Join {

    public static void main(String[] args) {

    System.out.println("Main thread started...");
    
        for (int i = 0; i < 10; i++) {
            System.out.println("Count in main Thread: " + i);
            try {
                
                Thread.sleep(1000);//main thread sleep
                
                if(i==3)
                {
                   JThread t= new JThread("JThread ");
                   t.start();
                   try{
                       t.join(); 
                   }
                   catch(InterruptedException e){
   
                       System.out.printf("%s has been interrupted", t.getName());
                   }
                   System.out.println("Main thread finished...");            
                }
                
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
