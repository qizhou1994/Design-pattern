package code.composite.eg1;

/**
 * Created by qizhou on 19-1-24.
 * 在组合中表示叶节点对象
 * 叶节点没有子节点
 */

public class Leaf extends Component {


    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("not add");
    }

    @Override
    public void remove(Component component) {
        System.out.println("not remove");
    }

    @Override
    public void display(int dept) {
        System.out.print(name);
        for (int i=1;i<=dept;i++) {
            System.out.print("-" );
        }
        System.out.println(dept);
    }
}
