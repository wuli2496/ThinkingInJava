package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

public class OverloadingVarargs {
    static void f(Character... args)
    {
        printnb("first");
        for(Character c : args)
        {
            printnb(" " + c);
        }
        print();
    }

    static void f(Integer... args)
    {
        printnb("second");
        for(int i : args)
        {
            printnb(" " + i);
        }

        print();
    }

    static void f(Long... args)
    {
        printnb("third");
        for (long l : args)
        {
            printnb(" " + l);
        }
        print();
    }

    public static void main(String[] args)
    {
        f('a', 'b', 'c');
        f(1);
        f(2, 1);
        f(0);
        f(0L);
    }
}
