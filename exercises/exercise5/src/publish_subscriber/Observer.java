package publish_subscriber;
/**
 * @ClassName SubscriptionSubject
 * @description:abstract observer(interface)
 * @author: Ziqi Meng
 **/
public interface Observer {
    void update(String message);
}
