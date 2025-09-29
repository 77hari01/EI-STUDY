# Factory Design Pattern - Food App 

This is a **Food Factory model** where **Pizza** and **Burger** are created using separate factories. The **Factory Design Pattern** is used to abstract the creation logic and allow easy addition of new food types without modifying existing code.

## Use Case

The use case is to create a **Food App** that allows users to order different types of food:
- A **PizzaFactory** creates pizzas like **chickenpizza** or **MushroomPizza**
- A **BurgerFactory** creates burgers like **CheeseBurger** or **VeggieBurger**
- The client (Food App) does not need to know the exact class of the food it is ordering; it only calls the factory to get the food object

This makes it easy to **extend the menu** without changing the client code.

## Implementation

### Abstract Factory
- **FoodFactory** (interface) defines a method `createFood()`
- Concrete factories implement this interface: **PizzaFactory** and **BurgerFactory**

### Concrete Products
- **Pizza** → chickenpizza, MushroomPizza
- **Burger** → CheeseBurger, VeggieBurger

## Example Classes

### 1. FoodFactory (Interface)
Defines a method `createFood()` that returns a `Food` object.

### 2. PizzaFactory
- Implements `FoodFactory`
- Creates pizza objects (chickenpizza, MushroomPizza)

### 3. BurgerFactory
- Implements `FoodFactory`
- Creates burger objects (CheeseBurger, VeggieBurger)

### 4. Food (Interface)
Common interface for all food items with a method `prepare()`.

### 5. Concrete Foods
- chickenpizza → implements Food
- MushroomPizza → implements Food
- CheeseBurger → implements Food
- VeggieBurger → implements Food

## Example Flow

1. Client (FoodApp) wants a pizza → calls `PizzaFactory.createFood("chickenpizza")` → gets `chickenpizza`
2. Client wants a burger → calls `BurgerFactory.createFood("CheeseBurger")` → gets `CheeseBurger`
3. The client calls `food.prepare()` → executes the preparation logic
4. New food can be added easily: e.g., `PastaFactory` → `Pasta` products without modifying existing factories
