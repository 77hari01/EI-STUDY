package Observer;

interface Subject {
    void addSubscriber(Observer o);
    void removeSubscriber(Observer o);
    void notifySubscribers(String message);
}