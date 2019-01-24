package code.composite.eg1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizhou on 19-1-24.
 *  定义有枝节点行为，用来存储子部件
 *  在Component借口中实现与子部件有关的操作，比如增加add和删除remove
 */

public class Composite extends Component {

    List<Component> list = new ArrayList<>();
    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public void display(int dept) {
        System.out.print(name);
        for (int i=1;i<=dept+2;i++) {
            System.out.print("-" );
        }
        System.out.println(dept+2);
        for(Component component:list){
            component.display(2+dept);
        }
    }
}
