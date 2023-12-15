package factory;

/**
 * @ClassName CoffeeStore
 * @description: Coffee Store use the CoffeeFactory to get Coffee
 * @author: Ziqi Meng
 **/
public class CoffeeStore {
    private  CoffeeFactory factory;
    public void setFactory(CoffeeFactory factory){
        this.factory = factory;
    }
    public Coffee orderCoffee(){
        Coffee coffee = factory.createCoffee();

        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}