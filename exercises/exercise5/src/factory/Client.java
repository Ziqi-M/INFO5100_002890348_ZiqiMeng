package factory;

/**
 * @ClassName Client
 * @description: Test Case
 * @author: Ziqi Meng
 **/
public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        CoffeeFactory factory = new AmericanoFactory();

        store.setFactory(factory);

        Coffee coffee = store.orderCoffee();
        System.out.println(coffee.getName());
    }

}