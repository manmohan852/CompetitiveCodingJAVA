package site.designPattern.behavioural.visitor.ex2;

public interface Visitor {

    public void visit(Book book);

    //visit other concrete items
    public void visit(CD cd);
    public void visit(DVD dvd);
}
