package site.designPattern.behavioural.visitor.ex3;

import java.util.Random;

public class ElementVisitorTest {

    public static void main(String[] args) {

        Visitor v = new ElementVisitor();

        Document d = new Document(generateUuid());
        d.elements.add(new JsonElement(generateUuid()));
        d.elements.add(new JsonElement(generateUuid()));
        d.elements.add(new XMLElement(generateUuid()));

        d.accept(v);
    }

    public static int  generateUuid(){
        return new Random().nextInt();
    }
}
