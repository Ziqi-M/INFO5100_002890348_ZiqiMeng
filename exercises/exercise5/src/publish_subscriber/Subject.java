package publish_subscriber;

/**
 * @ClassName SubscriptionSubject
 * @description:abstract subject(interface)
 * @author: Ziqi Meng
 **/
public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notify(String message);

}
