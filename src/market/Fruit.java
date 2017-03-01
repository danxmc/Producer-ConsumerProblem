/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;

import java.util.Random;

/**
 *
 * @author danx_
 */
class Fruit {

    //Attributes
    private String fruitType;

    public Fruit() {
        generateFruit();
    }

    public String getFruitType() {
        return fruitType;
    }
    
    //Generate a random fruit
    private synchronized void generateFruit() {
        Random r = new Random();
        int low = 0;
        int high = 4;
        int result = r.nextInt(high - low) + low;
        switch(result) {
            case 0:
                this.fruitType = "Apple";
                break;
            case 1:
                this.fruitType = "Orange";
                break;
            case 2:
                this.fruitType = "Banana";
                break;
            case 3:
                this.fruitType = "Pear";
                break;
        }
    }

}
