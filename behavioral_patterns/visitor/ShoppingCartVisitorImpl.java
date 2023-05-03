package behavioral_patterns.visitor;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        int cost = book.getPrice() > 50 ? book.getPrice() - 5 : book.getPrice();
        System.out.println("Book ISBN = " + book.getIsbnNumber() + ", cost = " + cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + ", cost = " + cost);
        return cost;
    }
}
