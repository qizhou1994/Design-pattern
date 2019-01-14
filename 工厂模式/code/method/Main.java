package code.method;

import code.simple_code.Fruit;

/**
 * Created by qizhou on 19-1-14.
 */

public class Main {

    public static void main(String[] args){

        Fruit fruit = new ProduceApple();
        fruit.fruitProperty();

        Fruit fruit1 = new ProduceBanana();
        fruit1.fruitProperty();

        Fruit fruit2 = new ProduceOriange();
        fruit2.fruitProperty();


    }
}
