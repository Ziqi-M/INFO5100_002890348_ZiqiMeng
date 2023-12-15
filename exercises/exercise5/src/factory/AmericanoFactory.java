package factory;

/**
 * @ClassName AmericanoFactory
 * @description: Factory for Americano
 * @author: Ziqi Meng
 **/
public class AmericanoFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new Americano();
    }
}