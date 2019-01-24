package code.composite.eg1;

/**
 * Created by qizhou on 19-1-24.
 */

public abstract class Component {

    protected String name;

    public Component(String name){
        this.name = name;
    }




    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display(int dept);

}
