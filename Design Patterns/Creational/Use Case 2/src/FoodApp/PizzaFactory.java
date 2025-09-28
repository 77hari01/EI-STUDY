package FoodApp;

class PizzaFactory implements FoodFactory {
    public Food createFood(String type) {
        if (type.equalsIgnoreCase("chickenpizza")) {
            return new chickenpizza();
        } else if (type.equalsIgnoreCase("mushroompizza")) {
            return new mushroompizza();
        }
        return null;
    }
}
