package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

class Window
{
    Window(int maker)
    {
        print("Window(" + maker + ")");
    }
}

class House
{
    Window w1 = new Window(1);
    House()
    {
        print("House()");
        w3 = new Window(33);
    }
    Window w2 = new Window(2);
    void f() {print("f()");}
    Window w3 = new Window(3);

    static {
        print("static initialize");
    }
}
public class OrderOfInitialization {
    public static void main(String[] args)
    {
        House h = new House();
        h.f();
    }
}
