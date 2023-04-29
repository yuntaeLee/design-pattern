package structural_patterns.bridge;

public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void fillColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }   
}
