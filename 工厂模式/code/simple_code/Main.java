package code.simple_code;

/**
 * Created by qizhou on 19-1-10.
 */

public class Main {


    public static void  main(String[] args){
        Fruit fruit = FruitFactory.createFruit("苹果");
        fruit.fruitProperty();

        Fruit fruit1 = FruitFactory.createFruit("香蕉");
        fruit1.fruitProperty();
    }
}
