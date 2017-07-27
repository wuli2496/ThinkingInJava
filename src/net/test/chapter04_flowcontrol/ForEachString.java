package net.test.chapter04_flowcontrol;

import static net.test.util.Print.*;

public class ForEachString {
    public static void main(String[] args)
    {
        for (char c : "An African Swallow".toCharArray())
        {
            print(c);
        }
    }
}
