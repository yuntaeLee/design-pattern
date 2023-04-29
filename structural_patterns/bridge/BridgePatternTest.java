package structural_patterns.bridge;

public class BridgePatternTest {
    
    public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.fillColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.fillColor();
    }
}
