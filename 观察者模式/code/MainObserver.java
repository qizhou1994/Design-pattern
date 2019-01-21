package code;

import code.one.ConcreateObserver;
import code.one.ConcreateSubject;

/**
 * Created by qizhou on 19-1-21.
 */

public class MainObserver {

    public static void main(String[] args){

        ConcreateSubject s = new ConcreateSubject();

        s.attach(new ConcreateObserver("observer1",s));
        s.attach(new ConcreateObserver("observer2",s));
        s.attach(new ConcreateObserver("observer3",s));
        s.setSubjectState("subject1");
        s.notifyMsg();
    }
}
