package code.one;

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

    //得到结论或反应
    public abstract void getConclusion();
}
