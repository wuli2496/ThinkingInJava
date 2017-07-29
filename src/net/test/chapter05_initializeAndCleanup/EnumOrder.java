package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

public class EnumOrder {
    public static void main(String[] args)
    {
        for (Spiciness s : Spiciness.values())
        {
            print(s + ", ordinal " + s.ordinal());
        }
    }
}
