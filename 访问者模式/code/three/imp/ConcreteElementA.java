package code.three.imp;

import code.three.Visitor;
import code.three.Element;

/**
 * Created by qizhou on 19-1-9.
 */

public class ConcreteElementA extends Element {


    @Override
    public void accpect(Visitor vistor) {
        vistor.visitConcreteElementA(this);
    }
}
