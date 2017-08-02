package net.test.chapter07_reusingClass;

import static net.test.util.Print.*;

class Shape
{
    Shape(int i)
    {
        print("Shape constructor");
    }

    void dispose()
    {
        print("Shape dispose()");
    }
}

class Circle extends Shape
{
    Circle(int i)
    {
        super(i);
        print("Drawing Circle");
    }

    void dispose()
    {
        print("Eraseing Circle");
        super.dispose();
    }
}

class Triangle extends Shape
{
    Triangle(int i)
    {
        super(i);
        print("Drawing Triangle");
    }

    void dispose()
    {
        print("Erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape
{
    private int start, end;
    Line(int start, int end)
    {
        super(start);
        this.start = start;
        this.end = end;
        print("Drawing Line: " + start + ", " + end);
    }

    void dispose()
    {
        print("Erasing Line: " + start + ", " + end);
        super.dispose();
    }
}

public class CADSystem extends Shape{
    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];

    CADSystem(int i)
    {
        super(i + 1);
        for (int j = 0; j < lines.length; j++)
        {
            lines[j] = new Line(j, j * j);
        }

        c = new Circle(1);
        t = new Triangle(1);
        print("Combined cconstructor");
    }

    public void dispose()
    {
        print("CADSystem dispose()");
        c.dispose();
        t.dispose();
        for (int i = 0; i < lines.length; i++)
        {
            lines[i].dispose();
        }
        super.dispose();
    }

    public static void main(String[] args)
    {
        CADSystem c = new CADSystem(47);
        try {

        } finally {
            c.dispose();
        }
    }
}
