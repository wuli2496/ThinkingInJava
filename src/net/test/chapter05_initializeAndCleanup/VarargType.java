package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

public class VarargType {
    static void f(Character... args)
    {
        printnb(args.getClass());
        print(" length: " + args.length);
    }

    static void g(int... args)
    {
        printnb(args.getClass());
        print(" length: " + args.length);
    }

    public static void main(String[] args)
    {
        f('a');
        f();
        g(1);
        g();
        print("int[]: " + new int[0].getClass());
    }
}
