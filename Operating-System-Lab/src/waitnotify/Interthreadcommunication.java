/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waitnotify;

/**
 *
 * @author User
 */
class Producer implements Runnable{

    QN q;
    public Producer(QN q) {
        this.q=q;
        new Thread(this, "Producer").start();
    }
    
    
    @Override
    public void run() {
        int i =0;
        while(i< 8){
            q.put(i++);
        }
    }
    
}

class Consumer implements Runnable{

    QN q;
    public Consumer(QN q) {
        this.q=q;
        new Thread (this, "Consumer").start();
    }
    
    
    @Override
    public void run() {
        
        
        while(true){
            q.get();
        }
    }
    
}

public class Interthreadcommunication {
    public static void main(String[] args) {
        
        QN q = new QN();
        new Producer(q);
        new Consumer(q);
    }
}
