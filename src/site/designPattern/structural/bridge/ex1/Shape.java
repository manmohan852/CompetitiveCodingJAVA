package site.designPattern.structural.bridge.ex1;

import site.designPattern.structural.bridge.ex1.Color;

public abstract class Shape {
    //Composition - implementor
    protected Color color;

    //constructor with implementor as input argument
    public Shape(Color c){
        this.color=c;
    }

    abstract public void applyColor();
}
