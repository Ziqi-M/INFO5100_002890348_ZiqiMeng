package publish_subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubscriptionSubject
 * @description:concrete subject
 * @author: Ziqi Meng
 **/
public class SubscriptionSubject implements Subject{

    List<Observer> UserList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        UserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        UserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : UserList) {
            observer.update(message);
        }
    }
}