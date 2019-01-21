package code.one;

/**
 * Created by qizhou on 19-1-21.
 */

public class ConcreateSubject extends Subject {

    private String subjectState;

    //具体被观察者状态

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
