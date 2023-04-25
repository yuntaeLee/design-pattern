package creational_patterns.singleton;

public class ReflectionResistantedSingleton {
    
    private static volatile ReflectionResistantedSingleton instance = null;

    private ReflectionResistantedSingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static ReflectionResistantedSingleton getInstance() {
        if (instance == null) {
            synchronized (ReflectionResistantedSingleton.class) {
                if (instance == null) {
                    instance = new ReflectionResistantedSingleton();
                }
            }
        }

        return instance;
    }
}
