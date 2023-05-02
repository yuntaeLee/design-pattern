package behavioral_patterns.state;

public class PendingState implements OrderState {

    @Override
    public void confirm(Order order) {
        order.setState(new ConfirmedState());
    }

    @Override
    public void ship(Order order) {
        throw new IllegalStateException("Cannot ship a pending order.");
    }

    @Override
    public void deliver(Order order) {
        throw new IllegalStateException("Cannot deliver a pending order.");
    }
}
