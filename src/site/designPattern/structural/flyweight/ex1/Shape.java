package site.designPattern.structural.flyweight.ex1;
import java.awt.*;
import java.awt.Color;
public interface Shape {

    public void draw(Graphics g, int x, int y, int width, int height,
                     Color color);
}
