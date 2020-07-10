package site.designPattern.behavioural.visitor.ex3;

public class XMLElement implements Element {
    int uuid;

    public XMLElement(int uuid){
        this.uuid = uuid;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
