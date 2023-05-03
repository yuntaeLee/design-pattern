package behavioral_patterns.visitor;

public class VisitorTest {
    
    public static void main(String[] args) {
        ItemElement[] items = { new Book(20, "1234"), new Book(100, "5678"),
                                new Fruit(10, 2, "Apple"), new Fruit(5, 5,  "Banana") };

        int total = calculatePrice(items);
        System.out.println("Total Cost = " + total);
    }

    private static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement item : items) {
            sum += item.accept(visitor);
        }
        return sum;
    }
}
