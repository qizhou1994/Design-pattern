package code.simple_code;

import code.simple_code.imp.Apple;
import code.simple_code.imp.Banana;
import code.simple_code.imp.Oriange;

/**
 * Created by qizhou on 19-1-10.
 */

public class FruitFactory {

    public static Fruit createFruit(String fruitname){
        Fruit fruits = null;

        switch (fruitname){
            case "苹果":
                fruits = new Apple();
                break;
            case "橘子":
                fruits = new Oriange();
                break;
            case "香蕉":
                fruits = new Banana();
                break;
                default:
        }

        return fruits;
    }

}
