package structural_patterns.bridge;

public abstract class Shape {
    
    protected Color color;

    protected Shape(Color color) {
        this.color = color;
    }

    abstract public void fillColor();
}
