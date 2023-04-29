package structural_patterns.decorator;

public class DecoratorPatternTest {
    
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assenble();

        System.out.println("=========");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assenble();
    }
}
