package net.test.chapter21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static net.test.util.Print.print;

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident)
    {
        generator = g;
        id = ident;
    }

    public void run()
    {
        while (!generator.isCanceled())
        {
            int val = generator.next();
            if (val % 2 != 0)
            {
                print(val + " not even!");
            }
        }
    }

    public static void test(IntGenerator gp, int count)
    {
        print("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++)
        {
            exec.execute(new EvenChecker(gp, i));
        }

        exec.shutdown();
    }

    public static void test(IntGenerator gp)
    {
        test(gp, 10);
    }
}
