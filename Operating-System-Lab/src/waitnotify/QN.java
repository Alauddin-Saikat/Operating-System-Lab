/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waitnotify;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class QN {
    
    int n;
    boolean value =false;
    
    synchronized int get(){
        while(!value){
            
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(QN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            System.out.println("Get : " + n);
            value=false;
            notify();
            return n;
        
    }
    
    synchronized void put(int n){
        
        while(value){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(QN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.n=n;
        System.out.println("Put : " + n);
        value=true;
        notify();
            
        
    }
    
}
