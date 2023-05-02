package behavioral_patterns.observer;

public class Database implements CacheObserver {

    private Cache cache;

    public Database(Cache cache) {
        this.cache = cache;
        this.cache.attach(this);
    }

    @Override
    public void update() {
        synchronized (cache) {
            System.out.println("Updating database with new data: " + cache.getData());
        }
    }
}
