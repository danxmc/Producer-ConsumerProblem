/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumerproblem;

/**
 *
 * @author danx_
 */
public class Consumer extends Thread {

    private MessageQueue queue = null;

    public Consumer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Consumidor lee el mensaje " + queue.getMessage() + " de la cola");
        }
    }
}
