package net.test.chapter21_concurrent;

import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;

public class SimpleDaemons implements Runnable {
    public void run()
    {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("sleep interrupted");
        }
    }

    public static void main(String[] args) throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            Thread t = new Thread(new SimpleDaemons());
            t.setDaemon(true);
            t.start();
        }
        print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
