package FoodApp;

class BurgerFactory implements FoodFactory {
    public Food createFood(String type) {
        if (type.equalsIgnoreCase("Cheese")) {
            return new CheeseBurger();
        } else if (type.equalsIgnoreCase("Veggie")) {
            return new VeggieBurger();
        }
        return null;
    }
}
