package behavioral_patterns.strategy;

public class ShoppingCartTest {
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);

        cart.addItem(item1);
        cart.addItem(item2);
        
        // pay by paypal
        cart.pay(new PaypalStrategy("yoon@example.com", "yoonpwd"));

        // pay by credit card
        cart.pay(new CreditCardStrategy("yoon", "123456789012345", "789", "12/01"));
    }
}
