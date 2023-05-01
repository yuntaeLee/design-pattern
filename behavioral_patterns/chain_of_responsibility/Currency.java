package behavioral_patterns.chain_of_responsibility;

public class Currency {
    
    private int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
