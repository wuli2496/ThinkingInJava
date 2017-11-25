package net.test.chapter21_concurrent;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.test.util.Print.print;
import static net.test.util.Print.printf;

abstract class Accumulator
{
    public static long cycles = 50000L;
    private static final int N = 4;
    public static ExecutorService exec = Executors.newFixedThreadPool(2 * N);
    private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);
    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";
    protected final static int SIZE = 100000;
    protected static int[] preLoaded = new int[SIZE];

    static {
        Random rand = new Random(47);
        for (int i = 0; i < SIZE; i++)
        {
            preLoaded[i] = rand.nextInt();
        }
    }

    public abstract void accumulate();
    public abstract long read();

    private class Modifier implements Runnable
    {
        public void run()
        {
            for (long i = 0; i < cycles; i++)
            {
                accumulate();
            }

            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class Reader implements Runnable
    {
        private volatile long value;

        public void run()
        {
            for (long i = 0; i < cycles; i++)
            {
                value = read();
            }

            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void timedTest()
    {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++)
        {
            exec.execute(new Modifier());
            exec.execute(new Reader());
        }

        try {
            barrier.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        duration = System.nanoTime() - start;
        printf("%-13s: %13d\n", id, duration);
    }

    public static void report(Accumulator acc1, Accumulator acc2)
    {
        printf("%-22s: %.2f\n", acc1.id + "/" + acc2.id, (double)acc1.duration / (double)acc2.duration);
    }
}

class BaseLine extends Accumulator
{
    {
        id = "BaseLine";
    }

    public void accumulate()
    {
        if (index >= SIZE) index = 0;
        value += preLoaded[index++];
        if (index >= SIZE) index = 0;
    }

    public long read()
    {
        return value;
    }
}

class SynchronizedTest extends Accumulator
{
    {
        id = "SynchronizedTest";
    }
    public synchronized void accumulate()
    {

        value += preLoaded[index++];
        if (index >= SIZE) index = 0;
    }

    public synchronized long read()
    {
        return value;
    }
}

class LockTest extends Accumulator
{
    {
        id = "LockTest";
    }
    private Lock lock = new ReentrantLock();

    public void accumulate()
    {
        lock.lock();
        try {

            value += preLoaded[index++];
            if (index >= SIZE) index = 0;

        } finally {
            lock.unlock();
        }
    }

    public long read()
    {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}

class AtomicTest extends Accumulator
{
    {
        id = "AtomicTest";
    }

    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);

    public void accumulate()
    {
        int i = index.getAndIncrement();
        if (i >= SIZE) {
            index.set(0);
            i = 0;
        }
        value.getAndAdd(preLoaded[i]);

    }

    public long read()
    {
        return value.get();
    }
}

public class SynchronizationComparisons {
    static BaseLine baseLine = new BaseLine();
    static SynchronizedTest synchronizedTest = new SynchronizedTest();
    static LockTest lockTest = new LockTest();
    static AtomicTest atomicTest = new AtomicTest();

    static void test()
    {
        print("=====================");
        printf("%-12s : %13d\n", "Cycles", Accumulator.cycles);
        baseLine.timedTest();
        synchronizedTest.timedTest();
        lockTest.timedTest();
        atomicTest.timedTest();
        Accumulator.report(synchronizedTest, baseLine);
        Accumulator.report(lockTest, baseLine);
        Accumulator.report(atomicTest, baseLine);
        Accumulator.report(synchronizedTest, lockTest);
        Accumulator.report(synchronizedTest, atomicTest);
        Accumulator.report(lockTest, atomicTest);
    }

    public static void main(String[] args)
    {
        int iterations = 5;
        if (args.length > 0)
        {
            iterations = new Integer(args[0]);
        }

        print("Warmup");
        baseLine.timedTest();
        for (int i = 0; i < iterations; i++)
        {
            test();
            Accumulator.cycles *= 2;
        }

        Accumulator.exec.shutdownNow();
    }
}
