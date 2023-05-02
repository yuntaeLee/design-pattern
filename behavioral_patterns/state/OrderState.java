package behavioral_patterns.state;

public interface OrderState {
    
    void confirm(Order order);
    void ship(Order order);
    void deliver(Order order);
}
