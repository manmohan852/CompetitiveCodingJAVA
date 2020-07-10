package site.designPattern.structural.bridge.ex1;

import site.designPattern.structural.bridge.ex1.Color;
import site.designPattern.structural.bridge.ex1.Shape;

public class Triangle extends Shape {

    public Triangle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }

}
