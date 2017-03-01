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
public class Producer extends Thread {

    private static int countA = 0;
    private static int countO = 0;
    private static int countB = 0;
    private static int countP = 0;
    private int num;
    private boolean p1, p2, p3;
    private FruitQueue queue = null;

    public Producer(FruitQueue queue, int pNum) {
        this.queue = queue;
        this.num = pNum;

        //Set process active
        switch (pNum) {
            case 1:
                p1 = true;
                break;
            case 2:
                p2 = true;
                break;
            case 3:
                p3 = true;
                break;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            queue.addFruit(generate());
        }
        System.out.println("Producer stopped production");
        setState(num);
    }

    private synchronized Fruit generate() {
        Fruit fruit = new Fruit();
        switch (fruit.getFruitType()) {
            case "Apple":
                countA++;
                System.out.println("Fruit " + fruit.getFruitType() + " # " + countA + " added to queue");
                break;
            case "Orange":
                countO++;
                System.out.println("Fruit " + fruit.getFruitType() + " # " + countO + " added to queue");
                break;
            case "Banana":
                countB++;
                System.out.println("Fruit " + fruit.getFruitType() + " # " + countB + " added to queue");
                break;
            case "Pear":
                countP++;
                System.out.println("Fruit " + fruit.getFruitType() + " # " + countP + " added to queue");
                break;
        }
        return fruit;
    }

    private synchronized void setState(int num) {
        switch(num) {
            case 1:
                p1 = false;
                break;
            case 2:
                p2 = false;
                break;
            case 3:
                p3 = false;
                break;
        }
        
        if (!(p1 && p2 && p3)) {
            System.out.println("Mercado cerrando");
            System.exit(0);
        }
    }
}
