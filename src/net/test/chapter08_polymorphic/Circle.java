package net.test.chapter08_polymorphic;

import static net.test.util.Print.*;

public class Circle extends Shape{
    @Override
    public void draw()
    {
        print("Circle.draw()");
    }

    @Override
    public void erase()
    {
        print("Circle.erase()");
    }

    @Override
    public void output()
    {
        print("Circle.output()");
    }
}
