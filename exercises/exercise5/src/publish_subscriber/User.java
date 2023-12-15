package publish_subscriber;

/**
 * @ClassName User as the implementation of Observer
 * @description:concrete Observer
 * @author: Ziqi Meng
 **/
public class User implements Observer{
    public User(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}