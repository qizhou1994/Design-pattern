package code.template;

/**
 * Created by qizhou on 19-1-15.
 */

public class ConcreateBuilder2 extends Builder{

    private Product product = new Product();

    @Override
    public void BuildPartA() {
        product.add("部件 构造2 A");
    }

    @Override
    public void BuildPartB() {
        product.add("部件 构造2 B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
