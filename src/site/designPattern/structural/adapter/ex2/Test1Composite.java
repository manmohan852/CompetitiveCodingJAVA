package site.designPattern.structural.adapter.ex2;

public class Test1Composite {
//https://dzone.com/articles/adapter-design-pattern-in-java
    public static void main(String[] args) {
        System.out.println("Creating drawing of shapes...");
        Drawing drawing = new Drawing();
        drawing.addShape(new Rectangle());
        drawing.addShape(new Circle());
        System.out.println("Drawing...");
        drawing.draw();
        System.out.println("Resizing...");
        drawing.resize();
    }
}
