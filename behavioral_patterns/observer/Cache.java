package behavioral_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    
    private List<CacheObserver> observers = new ArrayList<>();
    private String data;
    private final Object MUTEX = new Object();

    public void setData(String data) {
        synchronized (MUTEX) {
            this.data = data;
        }
        notifyObservers();
    }

    public String getData() {
        synchronized (MUTEX) {
            return this.data;
        }
    }

    public void attach(CacheObserver observer) {
        synchronized (MUTEX) {
            observers.add(observer);
        }
    }

    public void detach(CacheObserver observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    public void notifyObservers() {
        List<CacheObserver> observersCopy;
        synchronized (MUTEX) {
            observersCopy = new ArrayList<>(this.observers);
        }
        for (CacheObserver observer : observersCopy) {
            observer.update();
        }
    }
}
