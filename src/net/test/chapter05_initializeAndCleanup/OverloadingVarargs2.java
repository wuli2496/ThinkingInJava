package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

public class OverloadingVarargs2 {
    static void f(float f, Character... args)
    {
        print("first");
    }

    static void f(char c, Character... args)
    {
        print("second");
    }

    public static void main(String[] args)
    {
        f(1, 'a');
        f('a', 'b');
    }
}
