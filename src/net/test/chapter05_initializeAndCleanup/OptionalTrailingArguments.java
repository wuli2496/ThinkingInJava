package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

public class OptionalTrailingArguments {

    static void f(int required, String... args)
    {
        printnb("required: " + required + " ");
        for (String arg : args)
        {
            printnb(arg + " ");
        }
        print();
    }

    public static void main(String[] args)
    {
        f(1, "one");
        f(2, "two", "three");
        f(0);
    }
}
