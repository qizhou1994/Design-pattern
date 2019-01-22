package code.eventdelegation;

/**
 * Created by qizhou on 19-1-22.
 * 被观察者与观察者的统一接口
 */

public abstract class IEvent {

    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    /**
     * 添加观察者
     * @param object
     * @param methodName
     * @param args
     */
    public  abstract void addEventListener(Object object,String methodName, Object... args);

    /**
     * 事件分发给所有人
     */
    public  abstract void notifySubject();
}
