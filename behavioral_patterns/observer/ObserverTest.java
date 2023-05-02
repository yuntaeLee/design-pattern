package behavioral_patterns.observer;

public class ObserverTest {
    
    public static void main(String[] args) {
        Cache cache = new Cache();

        Database database = new Database(cache);
        RedisCache redisCache = new RedisCache(cache);

        cache.setData("Hellow, world!");
    }
}
