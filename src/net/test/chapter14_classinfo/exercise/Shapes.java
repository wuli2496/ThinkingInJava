package net.test.chapter14_classinfo.exercise;

/**
 * Created by John on 2017/6/23.
 */
import java.util.*;
import static net.test.util.Print.*;

abstract class Shape
{
    void draw()
    {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}

class Circle extends Shape
{
    public String toString()
    {
        return "Circle";
    }
}

class Square extends Shape
{
    public String toString()
    {
        return "Square";
    }
}

class Triangle extends Shape
{
    public String toString()
    {
        return "Triangle";
    }
}

class Rhomboid extends Shape
{
    public String toString()
    {
        return "Rhomboid";
    }
}

public class Shapes {
    public static void rotate(Shape shape)
    {
        if (shape instanceof Circle) return;
        print("rotate");
    }
    public static void main(String[] args)
    {
        Shape shape = new Rhomboid();
        Circle circle = null;
        if (shape instanceof Circle) {
            circle = (Circle) shape;
        }
        shape.draw();
        if (circle != null)
        circle.draw();
    }
}
