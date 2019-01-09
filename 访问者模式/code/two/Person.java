package code.two;

/**
 * Created by qizhou on 19-1-9.
 */

public abstract class Person {

    protected String action;

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    //接受
    public abstract void accpect(Actions vistor);


}
