package code.three;


import code.three.imp.ConcreteVisitor2;
import code.three.imp.ConcreteElementA;
import code.three.imp.ConcreteVisitor1;
import code.three.imp.ConcreteElementB;

/**
 * Created by qizhou on 19-1-9.
 */

public class Main {

    public static void main(String[] args) {

        ObjectStructure objectStructure = new ObjectStructure();
        ConcreteElementB concreteElementB = new ConcreteElementB();
        objectStructure.attach(concreteElementB);
        objectStructure.attach(new ConcreteElementA());

        //访问者
        ConcreteVisitor1 concreteVisitor1 = new ConcreteVisitor1();
        objectStructure.display(concreteVisitor1);

        //访问者
        ConcreteVisitor2 concreteVisitor2 = new ConcreteVisitor2();


        objectStructure.display(concreteVisitor2);


        objectStructure.detach(concreteElementB);
        objectStructure.display(concreteVisitor2);
    }
}
