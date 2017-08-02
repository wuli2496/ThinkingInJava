package net.test.chapter08_polymorphic;

import static net.test.util.Print.*;

public class Triangle extends Shape {
    @Override
    public void draw()
    {
        print("Triangle.draw()");
    }

    @Override
    public void erase()
    {
        print("Triangle.erase()");
    }

    @Override
    public void output()
    {
        print("Triangle.output()");
    }
}
