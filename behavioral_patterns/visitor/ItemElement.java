package behavioral_patterns.visitor;

public interface ItemElement {
    
    public int accept(ShoppingCartVisitor visitor);
}
