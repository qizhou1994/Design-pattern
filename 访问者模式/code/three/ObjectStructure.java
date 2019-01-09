package code.three;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizhou on 19-1-9.
 */

public class ObjectStructure {

    private List<Element> list = new ArrayList<>();

    public void attach(Element person) {
        list.add(person);
    }

    public void detach(Element person) {
        list.remove(person);
    }

    public void display(Visitor vistor) {
        for (Element person : list) {
            person.accpect(vistor);

        }
    }

}
