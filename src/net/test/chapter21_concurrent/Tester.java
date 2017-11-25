package net.test.chapter21_concurrent;

import net.test.util.Generated;
import net.test.util.RandomGenerator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static net.test.util.Print.print;
import static net.test.util.Print.printf;

public abstract class Tester<C> {
    static int testReps = 10;
    static int testCycles = 1000;
    static int containerSize = 1000;
    abstract C containerInitializer();
    abstract void startReadersAndWriters();
    C testContainer;
    String testId;
    int nReaders;
    int nWriters;
    volatile long readResult = 0;
    volatile long readTime = 0;
    volatile long writeTime = 0;
    CountDownLatch countDownLatch;
    static ExecutorService exec = Executors.newCachedThreadPool();
    Integer[] writeData;

    Tester(String testId, int nReaders, int nWriters)
    {
        this.testId = testId + " " + nReaders + "r " + nWriters + "w";
        this.nReaders = nReaders;
        this.nWriters = nWriters;

        writeData = Generated.array(Integer.class, new RandomGenerator.Integer(), containerSize);

        for (int i = 0; i < testReps; i++)
        {
            runTest();
            readTime = 0;
            writeTime = 0;
        }
    }

    void runTest()
    {
        countDownLatch = new CountDownLatch(nReaders + nWriters);
        testContainer = containerInitializer();
        startReadersAndWriters();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            print("countDownLatch interrupted");
        }

        printf("%-27s %14d %14d\n", testId, readTime, writeTime);
        if (readTime != 0 && writeTime != 0)
        {
            printf("%-27s %14d\n", "readTime + writeTime =", readTime + writeTime);
        }
    }

    abstract class TestTask implements Runnable
    {
        abstract void test();
        abstract void printResult();
        long duration;
        public void run()
        {
            long startTime = System.nanoTime();
            test();
            duration = System.nanoTime() - startTime;
            synchronized(Tester.this)
            {
                printResult();
            }
            countDownLatch.countDown();
        }
    }

    public static void initMain(String[] args)
    {
        if (args.length > 0)
        {
            testReps = new Integer(args[0]);
        }

        if (args.length > 1)
        {
            testCycles = new Integer(args[1]);
        }

        if (args.length > 2)
        {
            containerSize = new Integer(args[2]);
        }

        printf("%-27s %14s %14s\n", "Type", "ReadTime", "WriteTime");
    }
}
