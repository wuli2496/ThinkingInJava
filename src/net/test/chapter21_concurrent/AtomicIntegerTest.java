package net.test.chapter21_concurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static net.test.util.Print.print;

public class AtomicIntegerTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);

    public int getValue() {return i.get();}
    public void evenIncrement() {i.addAndGet(2);}

    public void run()
    {
        while (true)
        {
            evenIncrement();
        }
    }

    public static void main(String[] args)
    {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.print("Aborting");
                System.exit(0);
            }
        }, 5000);

        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while (true)
        {
            int val = ait.getValue();
            if (val % 2 != 0)
            {
                print(val);
                System.exit(0);
            }
        }
    }
}
