# Observer Pattern – Notification System

This project demonstrates the **Observer Design Pattern** using a **Notification System** example. The Observer pattern allows objects (Observers) to be notified automatically when the state of another object (Subject) changes.

## Use Case

The use case is to simulate a **Notification Service** where:
- Customers (Observers) subscribe to receive updates
- The service (Subject) sends notifications to all subscribed customers
- New customers can be added or removed dynamically

## Implementation

### 1. Observer Interface (`Observer`)
Declares the `update(String message)` method which is called when the Subject sends a notification.

### 2. Concrete Observer (`Customer`)
- Implements the `Observer` interface
- Receives messages via the `update()` method

### 3. Subject Interface (`Subject`)
Declares methods to:
- `addSubscriber(Observer observer)`
- `removeSubscriber(Observer observer)`
- `notifySubscribers(String message)`

### 4. Concrete Subject (`NotificationService`)
- Maintains a list of subscribers
- Notifies all subscribed observers when a message is sent

### 5. Client
- Creates predefined customers and subscribes them to the service
- Sends notifications directly using the `notifySubscribers()` method

## Example Flow

```
Hari received notification: Big Sale Today!
John received notification: Big Sale Today!
Priya received notification: Big Sale Today!
Hari received notification: New Product Launched!
John received notification: New Product Launched!
Priya received notification: New Product Launched!
```
