package net.test.chapter21_concurrent.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;

class WaitTest1 implements Runnable
{
    public synchronized void Wait() throws InterruptedException
    {
        wait();
    }

    public synchronized void Notify()
    {
        notifyAll();
    }

    public void run()
    {

        try {
            while (!Thread.interrupted()) {
                Wait();
                print("after wait");
            }
        } catch (InterruptedException e) {
            print("Interrupted");
        }

        print("Ending WaitTest1.run()");
    }
}

class WaitTest2 implements Runnable
{
    private WaitTest1 waitTest1;

    public WaitTest2(WaitTest1 waitTest1)
    {
        this.waitTest1 = waitTest1;
    }

    public void run()
    {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.SECONDS.sleep(1);
                waitTest1.Notify();
                print("notify()");
            }

        } catch (InterruptedException e) {
            print("Interrupted");
        }

        print("Ending WaitTest2");
    }
}

public class WaitTest {
    public static void main(String[] args) throws Exception
    {
        WaitTest1 waitTest1 = new WaitTest1();
        WaitTest2 waitTest2 = new WaitTest2(waitTest1);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(waitTest1);
        exec.execute(waitTest2);

        TimeUnit.SECONDS.sleep(60);
        exec.shutdownNow();
    }
}
