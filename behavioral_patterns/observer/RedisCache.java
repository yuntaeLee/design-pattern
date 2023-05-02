package behavioral_patterns.observer;

public class RedisCache implements CacheObserver {

    private Cache cache;

    public RedisCache(Cache cache) {
        this.cache = cache;
        this.cache.attach(this);
    }

    @Override
    public void update() {
        synchronized (cache) {
            System.out.println("Updating Redis cache with new data: " + cache.getData());
        }
    }
}
