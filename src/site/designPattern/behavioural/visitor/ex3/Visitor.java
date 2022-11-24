package site.designPattern.behavioural.visitor.ex3;

public interface Visitor {

    public void visit(JsonElement jsonElement);

    public void visit(XMLElement xmlElement);

}
