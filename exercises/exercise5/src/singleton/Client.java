package singleton;

/**
 * @ClassName Client
 * @description: Test Case for Singleton
 * @author: Ziqi Meng
 **/
public class Client {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }

}