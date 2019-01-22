package code.eventdelegation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizhou on 19-1-22.
 */

public class Boss extends IEvent {

    private EventHandler eventHandler;
    public String subjectState;

    @Override
    public EventHandler getEventHandler() {
        return eventHandler;
    }

    @Override
    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void addEventListener(Object object, String methodName, Object... args) {
        System.out.println("新的观察者");
        EventHandler handler = this.getEventHandler();
        handler.addEvent(object,methodName,args);
    }

    @Override
    public void notifySubject() {
        System.out.println("EventHandler 发出所有"+ subjectState);

        try {
            getEventHandler().notifyX();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
