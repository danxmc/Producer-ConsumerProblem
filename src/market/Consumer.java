/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;

/**
 *
 * @author danx_
 */
public class Consumer extends Thread {
    
    private FruitQueue queue = null;
    private String wantedFruit;
    private int num;

    public Consumer(FruitQueue queue, String wFruit, int num) {
        this.queue = queue;
        this.wantedFruit = wFruit;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Consumer " + num + " gets " + queue.getFruit(wantedFruit, num) + " from queue");
        }
    }
}
