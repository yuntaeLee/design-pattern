package structural_patterns.bridge;

public class Pentagon extends Shape {

    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void fillColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }
}
