package code.three;

import code.three.imp.ConcreteElementA;
import code.three.imp.ConcreteElementB;

/**
 * Created by qizhou on 19-1-9.
 */

public abstract class Visitor {

    //得到男人结论或反应
    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);

    //得到女人结论或反应
    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);
}
