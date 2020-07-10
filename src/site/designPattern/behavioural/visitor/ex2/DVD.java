package site.designPattern.behavioural.visitor.ex2;

public class DVD  implements Visitable{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
