package code.two;

import code.two.imp.Man;
import code.two.imp.Woman;

/**
 * Created by qizhou on 19-1-9.
 */

public abstract class Actions {

    //得到男人结论或反应
    public abstract void getManConclusion(Man man);

    //得到女人结论或反应
    public abstract void getWomanConclusion(Woman woman);
}
