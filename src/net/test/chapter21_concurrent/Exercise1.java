package net.test.chapter21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise1 implements Runnable {
    public Exercise1()
    {
        System.out.println("Exercise start");
    }

    public void run()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println("Exercise run i:" + i);
            Thread.yield();
        }
        System.out.println("Exercise stop");
    }

    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Exercise1());
        exec.shutdown();
    }
}
