package site.designPattern.structural.adapter.ex2.objectAdapter;

import site.designPattern.structural.adapter.ex2.*;

public class ObjectAdapterMain {

    public static void main(String[] args) {
        System.out.println("Creating drawing of shapes...");
        Drawing drawing = new Drawing();
        drawing.addShape(new Rectangle());
        drawing.addShape(new Circle());
        drawing.addShape(new GeometricShapeObjectAdapter(new Triangle()));
        drawing.addShape(new GeometricShapeObjectAdapter(new Rhombus()));
        System.out.println("Drawing...");
        drawing.draw();
        System.out.println("Resizing...");
        drawing.resize();
    }
}
