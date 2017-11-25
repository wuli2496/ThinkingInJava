package net.test.chapter21_concurrent;

public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public synchronized int next()
    {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args)
    {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
