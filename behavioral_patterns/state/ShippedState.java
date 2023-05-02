package behavioral_patterns.state;

public class ShippedState implements OrderState {

    @Override
    public void confirm(Order order) {
        throw new IllegalStateException("Order is already confirmed.");
    }

    @Override
    public void ship(Order order) {
        throw new IllegalStateException("Order is already shipped.");
    }

    @Override
    public void deliver(Order order) {
        order.setState(new DeliveredState());
    }
}
