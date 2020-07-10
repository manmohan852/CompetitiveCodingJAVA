package site.designPattern.behavioural.visitor.ex1;

public interface ShoppingCartVisitor {

    int visit(Book book);
    int visit(Fruit fruit);
}
