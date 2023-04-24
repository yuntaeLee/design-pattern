package creational_patterns;

public class StaticBlockSingleton {
    
    private static final StaticBlockSingleton instance;

    private StaticBlockSingleton() {}

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw RuntimeException("Creating singleton instance exception");
        }
    }

    public StaticBlockSingleton getInstance() {
        return instance;
    }
}
