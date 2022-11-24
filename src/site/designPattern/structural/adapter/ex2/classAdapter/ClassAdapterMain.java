package site.designPattern.structural.adapter.ex2.classAdapter;

import site.designPattern.structural.adapter.ex2.Circle;
import site.designPattern.structural.adapter.ex2.Drawing;
import site.designPattern.structural.adapter.ex2.Rectangle;

public class ClassAdapterMain {

    public static void main(String[] args) {
        System.out.println("Creating drawing of shapes...");
        Drawing drawing = new Drawing();
        drawing.addShape(new Rectangle());
        drawing.addShape(new Circle());
        drawing.addShape(new TriangleAdapter());
        drawing.addShape(new RhombusAdapter());
        System.out.println("Drawing...");
        drawing.draw();
        System.out.println("Resizing...");
        drawing.resize();
    }
}
