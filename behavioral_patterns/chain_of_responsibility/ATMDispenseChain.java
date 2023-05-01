package behavioral_patterns.chain_of_responsibility;

import java.util.Scanner;

public class ATMDispenseChain {
    
    private DispenseChain c1;

    public ATMDispenseChain() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        while (true) {
            System.out.println("Enter amount to dispense");
            Scanner sc = new Scanner(System.in);
            int amount = sc.nextInt();

            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }

            atmDispenser.c1.dispense(new Currency(amount));
        }
    }
}
