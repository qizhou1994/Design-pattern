package code.two.imp;

import code.two.Actions;
import code.two.Person;

/**
 * Created by qizhou on 19-1-9.
 */

public class Woman extends Person {


    @Override
    public void accpect(Actions vistor) {
        vistor.getWomanConclusion(this);
    }
}
