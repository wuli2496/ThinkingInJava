package net.test.chapter03_operator;

import static net.test.util.Print.*;

public class Overflow {
    public static void main(String[] args)
    {
        int big = Integer.MAX_VALUE;
        print("big = " + big);
        int bigger = big * 4;
        print("bigger = " + bigger);
    }
}
