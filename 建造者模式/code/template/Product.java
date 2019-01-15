package code.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizhou on 19-1-15.
 */

public class Product {

    List<String> parts = new ArrayList<>();

    public void add(String name) {
        parts.add(name);
    }

    public void show() {
        for (String name : parts
                ) {
            System.out.println("part name = " + name);
        }
    }
}
