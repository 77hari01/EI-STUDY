package Observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        Customer customer1 = new Customer("Hari");
        Customer customer2 = new Customer("John");
        Customer customer3 = new Customer("Priya");

        service.addSubscriber(customer1);
        service.addSubscriber(customer2);
        service.addSubscriber(customer3);

        service.notifySubscribers("Big Sale Today!");
        service.notifySubscribers("New Product Launched!");
    }
}