package publish_subscriber;

/**
 * @ClassName Client
 * @description: Test Case
 * @author: Ziqi Meng
 **/
public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new User("Dog"));
        subject.attach(new User("Cat"));

        subject.notify("Good");
    }
}