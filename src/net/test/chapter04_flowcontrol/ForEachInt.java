package net.test.chapter04_flowcontrol;

import static net.test.util.Print.*;
import static net.test.util.Range.*;

public class ForEachInt {
    public static void main(String[] args)
    {
        for (int i : range(10))
        {
            printnb(i + " ");
        }

        print();
        for (int  i : range(5, 10))
        {
            printnb(i + " ");
        }
        print();
        for (int i : range(5, 20, 3))
        {
            printnb(i + " ");
        }
        print();
    }
}
