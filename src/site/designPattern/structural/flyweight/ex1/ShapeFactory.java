package site.designPattern.structural.flyweight.ex1;

import java.util.HashMap;

public class ShapeFactory {

    private static final HashMap<ShapeType,Shape> shapes = new HashMap<ShapeType,Shape>();//Notice the use of Java Composition (shapes map).

    //Notice the use of Factory pattern in getShape method.
    public static Shape getShape(ShapeType type) {
        Shape shapeImpl = shapes.get(type);

        if (shapeImpl == null) {
            if (type.equals(ShapeType.OVAL_FILL)) {
                shapeImpl = new Oval(true);
            } else if (type.equals(ShapeType.OVAL_NOFILL)) {
                shapeImpl = new Oval(false);
            } else if (type.equals(ShapeType.LINE)) {
                shapeImpl = new Line();
            }
            shapes.put(type, shapeImpl);
        }
        return shapeImpl;
    }

    //Notice the use of Java Enum for type safety.
    public static enum ShapeType{
        OVAL_FILL,OVAL_NOFILL,LINE;
    }
}
