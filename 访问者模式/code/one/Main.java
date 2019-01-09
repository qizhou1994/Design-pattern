package code.one;

import java.util.ArrayList;
import java.util.List;

import code.one.imp.Man;
import code.one.imp.Woman;

/**
 * Created by qizhou on 19-1-9.
 */

public class Main {

    public static void main(String[] args){
        List<Person> list = new ArrayList<>();
        Person person = new Man();
        person.setAction("成功");
        list.add(person);

        Person person1 = new Man();
        person1.setAction("失败");
        list.add(person1);

        Person person2 = new Man();
        person2.setAction("恋爱");
        list.add(person2);

        Person person3= new Woman();
        person3.setAction("成功");
        list.add(person3);

        Person person4 = new Woman();
        person4.setAction("失败");
        list.add(person4);

        Person person5 = new Woman();
        person5.setAction("恋爱");
        list.add(person5);

        for (Person p :list) {
            p.getConclusion();
        }
    }
}
