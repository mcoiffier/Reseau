/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau3;

/**
 *
 * @author Morgan
 */
public class ThreadCounter extends Thread {
    int no_fin;
    int delay;

    public ThreadCounter(int fin,int att) {
        no_fin = fin;
        delay = att;
    }
    
    public void run(){
        for (int i = 0; i <= no_fin; i++) {
            System.out.println(this.getName()+":"+i);
            try {
                    sleep(delay);
                } catch (InterruptedException e) {
                }
        }
    }
    
    public static void main(String[] args) {
        ThreadCounter cp1 = new ThreadCounter(100, 100);
        ThreadCounter cp2 = new ThreadCounter(50, 200);
        cp1.start();
        cp2.start();
        
        
    }
    
    
}
