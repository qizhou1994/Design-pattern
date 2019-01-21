package code.one;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizhou on 19-1-21.
 */

public abstract class Subject {



    private List<Observer> observers = new ArrayList<>();

    //增加观察者
    public void attach(Observer observer){
        observers.add(observer);
    }

    //移除
    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyMsg(){
        for(Observer observer:observers){
            observer.update();
        }
    }
}
