package code.one;

/**
 * Created by qizhou on 19-1-21.
 */

public class ConcreateObserver extends Observer {


    private String name;
    private String observerState;
    private ConcreateSubject subject;

    public ConcreateObserver(String name,ConcreateSubject subject){
        this.name = name;
        this.subject = subject;
    }



    @Override
    public void update() {
        this.observerState = subject.getSubjectState();
        System.out.println("观察者"+name+"的新状态是"+ observerState);
    }

    public ConcreateSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreateSubject subject) {
        this.subject = subject;
    }
}
