package net.test.chapter21_concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;

class SleepBlocked implements Runnable
{
    public void run()
    {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            print("InterruptedException");
        }

        print("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable
{
    private InputStream in;

    public IOBlocked(InputStream in) {this.in = in;}

    public void run()
    {
        try {
            print("Wating for read();");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                print("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }

        print("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable
{
    public synchronized void f()
    {
        while (true)
        {
            Thread.yield();
        }
    }

    public SynchronizedBlocked()
    {
        new Thread()
        {
            public void run()
            {
                f();
            }
        }.start();
    }

    public void run()
    {
        print("Tring to call f()");

        f();

        print("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException
    {
        Future<?> f = exec.submit(r);
        TimeUnit.SECONDS.sleep(1);
        print("Interrupting " + r.getClass().getName());
        f.cancel(true);
        print("Interrupt send to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception
    {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());

        TimeUnit.SECONDS.sleep(10);
        print("Aborting with System.exit(0)");
        System.exit(0);
    }
}
