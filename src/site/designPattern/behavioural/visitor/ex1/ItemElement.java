package site.designPattern.behavioural.visitor.ex1;

public interface ItemElement {
    public int accept(ShoppingCartVisitor visitor);
}
