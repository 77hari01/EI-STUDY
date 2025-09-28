package FoodApp;

public class Foodapp {
    public static void main(String[] args) {

        FoodFactory pizzaFactory = new PizzaFactory();
        Food pizza1 = pizzaFactory.createFood("chickenpizza");
        pizza1.prepare();

        Food pizza2 = pizzaFactory.createFood("mushroompizza");
        pizza2.prepare();

        FoodFactory burgerFactory = new BurgerFactory();
        Food burger1 = burgerFactory.createFood("Cheese");
        burger1.prepare();

        Food burger2 = burgerFactory.createFood("Veggie");
        burger2.prepare();
    }
}

