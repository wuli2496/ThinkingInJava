package net.test.chapter03_operator;

import static net.test.util.Print.*;

public class AutoInc {
    public static void main(String[] args)
    {
        int i = 1;
        print("i: " + i);
        print("++i: " + ++i);
        print("i++: " + i++);
        print("i: " + i);
        print("--i: " + --i);
        print("i--: " + i--);
        print("i: " + i);
    }
}
