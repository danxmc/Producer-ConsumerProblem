/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danx_
 */
public class FruitQueue {

    //Attributes
    private int bufferSize;
    private List<Fruit> queue = new ArrayList<>();

    //Methods
    public FruitQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Must be positive int");
        }
        this.bufferSize = size;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized boolean isFull() {
        return queue.size() == bufferSize;
    }

    public synchronized String getFruit(String wfruit, int consNum) {
        String out = null;

        while (isEmpty() || !wfruit.equals(queue.get(0).getFruitType())) {
            if (isEmpty()) {
                System.out.println("Nothing on queue");
            } else {
                System.out.println("Wanted fruit is not available for Consumer " + consNum);
            }

            try {
                //Pon el thread actual a esperar
                wait();
                
            } catch (InterruptedException ex) {
                //el thread puede entregarse

            }
        }

        //consume el primer mensaje en la cola
        out = queue.remove(0).getFruitType();

        //despierta a todos los threads esperando
        notifyAll();
        return out;
    }

    public synchronized void addFruit(Fruit in) {
        //esperar hasta que la cola no este llena
        while (isFull()) {
            System.out.println("Queue is full");
            try {
                //pone el thread actual a esperar
                wait();
            } catch (InterruptedException ex) {
                //el thread puede ingresar a la cola
            }
        }
        queue.add(in);
        //System.out.println("Added to queue: " + in.getFruitType());
        // despierta todos los threads esperando
        notifyAll();
    }
}
