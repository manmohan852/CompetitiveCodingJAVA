package site.designPattern.behavioural.visitor.ex3;

public class JsonElement implements Element {

    int uuid;

    public JsonElement(int uuid){
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
