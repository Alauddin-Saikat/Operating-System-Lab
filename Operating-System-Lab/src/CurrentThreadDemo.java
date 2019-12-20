
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        
        System.out.println("Current Thread : " + t);
        
        // change the anme of the thread
        t.setName("My Thread");
        System.out.println("After changing the name : " + t);
        
        for (int n=5 ; n>0 ; n--){
            System.out.println(n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Main Thread Interrupted");
            }
        }
    }
   
}
