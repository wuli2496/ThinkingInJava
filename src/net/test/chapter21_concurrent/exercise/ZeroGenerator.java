package net.test.chapter21_concurrent.exercise;

import net.test.chapter21_concurrent.EvenChecker;
import net.test.chapter21_concurrent.IntGenerator;

public class ZeroGenerator extends IntGenerator{
    private int a = 0;
    private int b = 0;

    public int next()
    {
        a++;
        b++;
        return a - b;
    }

    public static void main(String[] args)
    {
        EvenChecker.test(new ZeroGenerator());
    }
}
