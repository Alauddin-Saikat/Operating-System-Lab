/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Synchro;

/**
 *
 * @author User
 */
class Obj implements Runnable{

    Caller caller;
    String message;
    Thread t ;
    public Obj(Caller caller,String message) {
        this.caller=caller;
        this.message=message;
        t = new Thread(this);
        t.start();
    }

    
    
    @Override
    public void run() {
            caller.callme(message);
        
    }
    
}


public class Synch {
    public static void main(String[] args) {
        Caller caller= new Caller();
    
        
        Obj obj1 = new Obj(caller,"Hello");
        Obj obj2 = new Obj(caller,"Everyone");
        
        Obj obj3 = new Obj(caller,"Good ");
        
    }
}
