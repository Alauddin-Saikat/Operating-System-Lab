/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
class NewThread extends Thread{

    public NewThread() {
        //create a new ,second thread
        super("Demo Thread");
        System.out.println("Child Thread :" + this);
        start(); //start the thread
    }

    @Override
    public void run() {
        for(int i=5 ; i>0 ; i--){
            System.out.println("Child thead " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Child thread interrupted.");
            }
        }
        System.out.println("Exiting child thread.");
    }
    
}

public class ExtendedThread {
    public static void main(String[] args) {
        new NewThread();
        
        for (int i=5 ; i>0 ; i--){
            System.out.println("Main threa : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread exiting.");
    }
}
