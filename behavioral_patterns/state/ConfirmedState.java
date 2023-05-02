package behavioral_patterns.state;

public class ConfirmedState implements OrderState {

    @Override
    public void confirm(Order order) {
        throw new IllegalStateException("Order is alerady confirmed.");
    }

    @Override
    public void ship(Order order) {
        order.setState(new ShippedState());
    }

    @Override
    public void deliver(Order order) {
        throw new IllegalStateException("Cannot deliver a unshipped order.");
    }
}
