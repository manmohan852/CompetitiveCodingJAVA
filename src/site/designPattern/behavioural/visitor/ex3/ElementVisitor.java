package site.designPattern.behavioural.visitor.ex3;

public class ElementVisitor implements Visitor {

    @Override
    public void visit(JsonElement jsonElement) {
        System.out.println(
                "processing a JSON element with uuid: " + jsonElement.uuid);
    }

    @Override
    public void visit(XMLElement xmlElement) {
        System.out.println(
                "processing an XML element with uuid: " + xmlElement.uuid);
    }
}
