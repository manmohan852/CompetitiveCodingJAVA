package site.designPattern.structural.adapter.ex2.classAdapter;


import site.designPattern.structural.adapter.ex2.Shape;
import site.designPattern.structural.adapter.ex2.Triangle;

public class TriangleAdapter extends Triangle implements Shape {
    public TriangleAdapter() {
        super();
    }

    @Override
    public void draw() {
        this.drawShape();
    }

    @Override
    public void resize() {
        System.out.println("Triangle can't be resized. Please create new one with required values.");
    }

    @Override
    public String description() {
        return "Triangle object";
    }

    @Override
    public boolean isHide() {
        return false;
    }
}
