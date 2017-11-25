package net.test.chapter21_concurrent;

import static net.test.util.Print.print;

public class Fat {
    private volatile double d;
    private static int counter = 0;
    private final int id = counter++;

    public Fat()
    {
        for (int i = 1; i < 10000; i++)
        {
            d += (Math.PI + Math.E) / (double)i;
        }
    }

    public void operation()
    {
        print(this);
    }

    public String toString()
    {
        return "Fat id: " + id;
    }
}
