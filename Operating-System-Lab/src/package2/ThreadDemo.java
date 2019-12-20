/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
//creating new thread
class NewThread implements Runnable{
    Thread t;

    public NewThread() {
        //create a new second thread
        t= new Thread(this,"Demo Thread.");
        System.out.println("Child Thrad : " + t);
        t.start();
    }
    
    //this is the entry point of second thread
    @Override
    public void run() {
            try {
                for (int i=5 ; i>0 ; i--){
                    System.out.println("Child Thread : " + i);
                    t.sleep(1000);
                }
                
            } catch (InterruptedException ex) {
                System.out.println("Child interrupted.");
            }
        System.out.println("Exiting child thread.");
    }
    
}


public class ThreadDemo {
    public static void main(String[] args) {
        new NewThread();  // create new Thread
        
        for(int i=5 ; i>0 ; i--){
            System.out.println("Main Thread : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Main interrupted.");
            }
        }
        System.out.println(" Exiting Main  Thread.");
    }
}
