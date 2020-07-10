package site.designPattern.behavioural.visitor.ex3;

import java.util.ArrayList;
import java.util.List;

public class Document implements Element {

    int uuid;

    public Document(int uuid){
        this.uuid = uuid;
    }

    List<Element> elements = new ArrayList<>();

    @Override
    public void accept(Visitor v) {
        for (Element e : this.elements) {
            e.accept(v);
        }
    }
}
