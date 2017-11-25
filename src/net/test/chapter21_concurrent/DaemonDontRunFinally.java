package net.test.chapter21_concurrent;

import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;

class ADaemon implements Runnable
{
    public void run()
    {
        try {
            print("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            print("Exiting via InterrupatedException");
        } finally {
            print("This should always run?");
        }
    }
}

public class DaemonDontRunFinally {
    public static void main(String[] args) throws Exception
    {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(1);
    }
}
