package code.composite.eg1;

/**
 * Created by qizhou on 19-1-24.
 */

public class Client {
    public static void main(String[] args){

        Composite composite = new Composite("root1");

        composite.add(new Leaf("a"));
        composite.add(new Leaf("b"));


        Composite composite2 = new Composite("root2");

        composite2.add(new Leaf("a2"));
        composite2.add(new Leaf("b2"));
        composite.add(composite2);

        Composite composite3 = new Composite("root3");
        composite3.add(new Leaf("a3"));
        composite3.add(new Leaf("b3"));
        composite2.add(composite3);

        composite.display(1);
    }
}
