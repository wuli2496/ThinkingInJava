package net.test.chapter21_concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger ai = new AtomicInteger(0);

    public int next()
    {
        return ai.addAndGet(2);
    }

    public static void main(String[] args)
    {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
