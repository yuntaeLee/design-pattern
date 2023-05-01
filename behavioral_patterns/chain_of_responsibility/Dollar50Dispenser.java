package behavioral_patterns.chain_of_responsibility;

public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 50) {
            int num = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing " + num + " 50$ note");

            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
            return;
        }

        this.chain.dispense(currency);
    }
}
