package net.test.chapter21_concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;

class TaskPortion implements Runnable
{
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch)
    {
        this.latch = latch;
    }

    public void doWork() throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(200));
        print(this + " completed");
    }

    public String toString()
    {
        return String.format("%1$-3d", id);
    }

    public void run()
    {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {

        }
    }
}

class WaitingTask implements Runnable
{
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    WaitingTask(CountDownLatch latch)
    {
        this.latch = latch;
    }

    public void run()
    {
        try {
            latch.await();
            print("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            print(this + " interrupted");
        }
    }

    public String toString()
    {
        return String.format("WaitingTask %1$-3d", id);
    }
}

public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) throws Exception
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++)
        {
            exec.execute(new WaitingTask(latch));
        }

        for (int i = 0; i < SIZE; i++)
        {
            exec.execute(new TaskPortion(latch));
        }

        exec.shutdown();
    }
}
