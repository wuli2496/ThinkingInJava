package net.test.chapter21_concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class Incrementable
{
    protected long count = 0;

    public abstract void increment();
}

class SynchronizingTest extends Incrementable
{
    public synchronized void increment()
    {
        count++;
    }
}

class LockingTest extends Incrementable
{
    private Lock lock = new ReentrantLock();

    public void increment()
    {
        lock.lock();
        try {
            ++count;
        } finally {
            lock.unlock();
        }
    }
}

public class SimpleMicoBenchmark {
    static long test(Incrementable incr)
    {
        long start = System.nanoTime();
        for (long i = 0; i < 10000000L; i++)
        {
            incr.increment();
        }
        return System.nanoTime() - start;
    }

    public static void main(String[] args)
    {
        long synchTime = test(new SynchronizingTest());
        long lockTime = test(new LockingTest());

        System.out.printf("synchronized: %1$10d\n", synchTime);
        System.out.printf("Lock: %1$10d\n", lockTime);
        System.out.printf("Lock/synchronized = %1$.3f", (double)lockTime / (double)synchTime);
    }
}
