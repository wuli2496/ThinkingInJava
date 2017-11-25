package net.test.chapter21_concurrent;

import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;

class NeedCleanup
{
    private final int id;
    public NeedCleanup(int ident)
    {
        id = ident;
        print("NeedCleanup " + id);
    }

    public void cleanup()
    {
        print("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable
{
    private volatile  double d = 0.0;

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                NeedCleanup n1 = new NeedCleanup(1);
                try {
                    print("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedCleanup n2 = new NeedCleanup(2);
                    try {
                        print("Calculating");
                        for (int i = 1; i < 2500000; i++)
                        {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        print("finished time-consuming operation");
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            print("Exiting via while() test");
        } catch (InterruptedException e) {
            print("Exiting via InterruptException");
        }
    }
}
public class InterruptingIdiom {
    public static void main(String[] args) throws Exception
    {
        if (args.length != 1)
        {
            print("usage: java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }

        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
}
