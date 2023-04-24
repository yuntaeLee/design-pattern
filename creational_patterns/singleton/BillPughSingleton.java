package creational_patterns.singleton;

public class BillPughSingleton {

    private BillPughSingleton() {}

    private static class SingletonHeler {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHeler.INSTANCE;
    }
}
