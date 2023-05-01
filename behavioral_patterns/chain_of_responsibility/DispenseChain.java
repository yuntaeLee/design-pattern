package behavioral_patterns.chain_of_responsibility;

public interface DispenseChain {
    
    void setNextChain(DispenseChain nextChain);

    void dispense(Currency currency);
}
