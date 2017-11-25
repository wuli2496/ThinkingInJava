package net.test.chapter21_concurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;
import static net.test.util.Print.printnb;

class Blocker
{
    synchronized void waitingAll()
    {
        try {
            while (!Thread.interrupted())
            {
                wait();
                printnb(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            print("Blocker Interrupted");
        }
    }

    synchronized void prod() {notify();}
    synchronized void prodAll() {notifyAll();}
}

class Task implements Runnable
{
    static Blocker blocker = new Blocker();
    public void run()
    {
        blocker.waitingAll();
    }
}

class Task2 implements Runnable
{
    static Blocker blocker = new Blocker();
    public void run()
    {
        blocker.waitingAll();
    }
}

public class NotifyVsNotifyAll {
    public static void main(String[] args) throws Exception
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
        {
            exec.execute(new Task());
        }

        exec.execute(new Task2());

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if (prod)
                {
                    printnb("\nnotify() ");
                    Task.blocker.prod();
                    prod = false;
                }
                else
                {
                    printnb("\nnotifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }

            }
        }, 400, 400);

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        print("\nTimer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        print("\nShutting down");
        exec.shutdownNow();
    }
}
