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
public class Producer extends Thread {

    private static int count = 0;
    private MessageQueue queue = null;

    public Producer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            queue.addMessage(generateMessage());
        }
    }

    private synchronized String generateMessage() {
        String msg = "MSG# " + count;
        count++;
        return msg;
    }
}
