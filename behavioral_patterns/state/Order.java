package behavioral_patterns.state;

public class Order {

    private OrderState state = new PendingState();

    public void setState(OrderState state) {
        this.state = state;
    }

    public void confirm() {
        state.confirm(this);
    }

    public void ship() {
        state.ship(this);
    }

    public void deliver() {
        state.deliver(this);
    }
}
