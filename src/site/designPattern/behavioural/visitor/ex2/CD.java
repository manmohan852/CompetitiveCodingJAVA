package site.designPattern.behavioural.visitor.ex2;

public class CD implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
