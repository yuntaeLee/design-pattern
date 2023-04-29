package structural_patterns.decorator;

public class SportsCar extends CarDecorator {

    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assenble() {
        super.assenble();
        System.out.println(" Adding features of Sports Car.");
    }
}
