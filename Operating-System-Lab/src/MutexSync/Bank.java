/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MutexSync;

/**
 *
 * @author User
 */
public class Bank extends Thread{
    int to_n;

    public Bank(int to_n) {
        this.to_n = to_n;
        
        
    }

    @Override
    public void run() {
        if(this.to_n == 1){
            for(int i=0 ; i<1 ; i++){
                while(ThreadSync.mutex == 1){
                    
                }
                ThreadSync.mutex = 1;
                operation();
            }
        }
        else{
            for(int i=0 ; i<1 ; i++){
                while(ThreadSync.mutex == 1){
                    
                }
                ThreadSync.mutex = 1;
                operation();
            }
        }
    }
    
    synchronized void operation(){
        if(to_n == 1){
            ThreadSync.balance+= 1000;
            System.out.println("New balance is : " + ThreadSync.balance + "for Thred " + this.to_n);
            ThreadSync.mutex = 0 ;
        }
        else {
            ThreadSync.balance-= 1000;
            System.out.println("New balance is : " + ThreadSync.balance + "for Thred " + this.to_n);
            ThreadSync.mutex = 0 ;
        }
    }
}
