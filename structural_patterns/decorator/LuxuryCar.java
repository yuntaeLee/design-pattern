package structural_patterns.decorator;

public class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assenble() {
        super.assenble();
        System.out.println(" Adding features of Luxury Car.");
    }
}
