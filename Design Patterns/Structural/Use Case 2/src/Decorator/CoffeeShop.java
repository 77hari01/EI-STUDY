package Decorator;

public class CoffeeShop {
    public static void main(String[] args) {
        Coffee myCoffee = new SimpleCoffee();
        myCoffee = new MilkDecorator(myCoffee);
        myCoffee = new SugarDecorator(myCoffee);

        System.out.println("Coffee Order: " + myCoffee.getDescription());
        System.out.println("Total Cost: " + myCoffee.getCost());
    }
}