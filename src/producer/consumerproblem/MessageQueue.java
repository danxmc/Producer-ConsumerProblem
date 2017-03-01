/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumerproblem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danx_
 */
public class MessageQueue {
    //el tamano de el buffer

    private int bufferSize;

    //el buffer list de tipo de strings 
    private List<String> buffer = new ArrayList<>();

    //construir la cola de mensajes 
    public MessageQueue(int bufferSize) {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("El tamaño es ilegal");
        }
        this.bufferSize = bufferSize;
    }

    //Checa si el buffer esta vacio
    public synchronized boolean isEmpty() {
        return buffer.isEmpty();
    }

    //Checa si el buffer esta lleno
    public synchronized boolean isFull() {
        return buffer.size() == bufferSize;
    }

    // pone un mensaje en la cola, llamado por el productor
    public synchronized void addMessage(String message) {
        //esperar hasta que la cola no este llena
        while (isFull()) {
            System.out.println("La cola esta llena");
            try {
                //pone el thread actual a esperar
                wait();
            } catch (InterruptedException ex) {
                //el thread puede ingresar a la cola
            }
        }
        buffer.add(message);
        System.out.println("Added messageto queue: " + message);
        // despierta todos los threads esperando
        notifyAll();
    }

    // obtiene un mensaje de la cola, llamado por el consumidor
    public synchronized String getMessage() {
        String message = null;
        //espera hasta que la cola no este vacia
        while (isEmpty()) {
            System.out.println("No hay mensajes en la cola");
            try {
                //Pon el thread actual a esperar
                wait();
            } catch (InterruptedException ex) {
                //el thread puede entregarse
            }
        }

        //consume el primer mensaje en la cola
        message = buffer.remove(0);

        //despierta a todos los threads esperando
        notifyAll();
        return message;
    }
}
