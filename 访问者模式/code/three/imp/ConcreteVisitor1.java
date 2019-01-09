package code.three.imp;


import code.three.Visitor;

/**
 * Created by qizhou on 19-1-9.
 */

public class ConcreteVisitor1 extends Visitor {


    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println( concreteElementA.getClass().getSimpleName() +" 开心");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println( concreteElementB.getClass().getSimpleName() +" 美滋滋");
    }
}
