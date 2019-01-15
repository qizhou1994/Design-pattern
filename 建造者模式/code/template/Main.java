package code.template;

/**
 * Created by qizhou on 19-1-15.
 */

public class Main {


    public static void main(String[] args){

        //构建创造者
        ConcreateBuilder1 concreateBuilder1 = new ConcreateBuilder1();

        ConcreateBuilder2 concreateBuilder2 = new ConcreateBuilder2();

        Director director = new Director();

        //指挥家去调用创建者的方法
        director.build(concreateBuilder1);
        director.build(concreateBuilder2);

        //得到产品
        Product product1 = concreateBuilder1.getResult();
        Product product2 = concreateBuilder2.getResult();

        product1.show();
        product2.show();


    }
}
