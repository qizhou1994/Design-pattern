package code.three.imp;


import code.three.Visitor;

/**
 * Created by qizhou on 19-1-9.
 */

public class ConcreteVisitor2 extends Visitor {



    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println( concreteElementA.getClass().getName() +" 买买买");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass().getName() +"  喝喝喝");
    }
}
