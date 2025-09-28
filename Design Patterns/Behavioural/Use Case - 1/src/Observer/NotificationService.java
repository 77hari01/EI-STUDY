package Observer;

import java.util.ArrayList;
import java.util.List;

class NotificationService implements Subject {
    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void addSubscriber(Observer o) {
        subscribers.add(o);
        System.out.println(((Customer) o).toString() + " subscribed!");
    }

    @Override
    public void removeSubscriber(Observer o) {
        subscribers.remove(o);
        System.out.println(((Customer) o).toString() + " unsubscribed!");
    }

    @Override
    public void notifySubscribers(String message) {
        for (Observer o : subscribers) {
            o.update(message);
        }
    }
}