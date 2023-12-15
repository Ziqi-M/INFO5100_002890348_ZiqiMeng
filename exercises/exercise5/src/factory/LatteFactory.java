package factory;

/**
 * @ClassName LatteFactory
 * @description: Concrete Factory for Latte
 * @author: Ziqi Meng
 **/
public class LatteFactory implements CoffeeFactory{

    @Override
    public Coffee createCoffee() {
        return new Latte();
    }
}