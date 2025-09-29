# Decorator Pattern – Coffee Example

This project demonstrates the **Decorator Design Pattern** using a **Coffee Shop** example. The Decorator pattern allows behavior to be added to individual objects dynamically without affecting other objects of the same class.

## Use Case

The use case is to create a **Coffee** object and **decorate** it with additional ingredients such as **Milk** and **Sugar**, while keeping the original Coffee class unchanged.

## Implementation

### 1. Component Interface (`Coffee`)
Declares methods:
- `getDescription()` → Returns a description of the coffee
- `getCost()` → Returns the cost of the coffee

### 2. Concrete Component (`SimpleCoffee`)
- Implements the base coffee
- Provides base description and cost

### 3. Abstract Decorator (`CoffeeDecorator`)
- Implements `Coffee` interface
- Contains a reference to a `Coffee` object
- Forces subclasses to override `getDescription()` and `getCost()`

### 4. Concrete Decorators (`MilkDecorator`, `SugarDecorator`)
- Add extra functionality (milk, sugar) to the coffee
- Update description and cost dynamically

### 5. Client
- Wraps a `SimpleCoffee` object with decorators
- Combines multiple decorators to create the final coffee order

## Example Flow

```
Coffee Order: Simple Coffee + Milk + Sugar
Total Cost: 8.0
```