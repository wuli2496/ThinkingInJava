package net.test.chapter08_polymorphic;

import static net.test.util.Print.*;

public class Square extends Shape {

    @Override
    public void draw()
    {
        print("Square.draw()");
    }

    @Override
    public void erase()
    {
        print("Square.erase()");
    }

    @Override
    public void output()
    {
        print("Square.output()");
    }

}
