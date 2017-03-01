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
public class Market {
    public static void main(String[] args) {
        FruitQueue queue = new FruitQueue(5);
        new Producer(queue, 1).start();
        new Producer(queue, 2).start();
        new Producer(queue, 3).start();
        new Consumer(queue, "Apple", 1).start();
        new Consumer(queue, "Banana", 2).start();
        new Consumer(queue, "Orange", 3).start();
        new Consumer(queue, "Pear", 4).start();
    }
}
