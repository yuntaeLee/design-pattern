package behavioral_patterns.state;

public class OrderStateTest {
    
    public static void main(String[] args) {
        Order order = new Order();
        order.confirm();
        order.ship();
        order.deliver();
    }
}
