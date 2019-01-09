package code.two;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizhou on 19-1-9.
 */

public class ObjectStructure {

    private List<Person> list = new ArrayList<>();

    public void attach(Person person) {
        list.add(person);
    }

    public void detach(Person person) {
        list.remove(person);
    }

    public void display(Actions vistor) {
        for (Person person : list) {
            person.accpect(vistor);

        }
    }

}
