package net.test.chapter21_concurrent.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;

class Flag
{
    private boolean flag = false;

    public synchronized void setFlag(boolean flag)
    {
        this.flag = flag;
        notifyAll();
    }

    public synchronized boolean getFlag()
    {
        return flag;
    }

    public synchronized void Wait() throws InterruptedException
    {
        while (flag == false) wait();
    }
}

class Task1 implements Runnable
{
    private Flag flag;

    public Task1(Flag flag)
    {
        this.flag = flag;
    }

    public void run()
    {
        try {
            TimeUnit.SECONDS.sleep(1);
            flag.setFlag(true);
        } catch (InterruptedException e) {
            print("Task1 interrupted");
        }
    }
}

class Task2 implements Runnable
{
    private Flag flag;

    public Task2(Flag flag)
    {
        this.flag = flag;
    }

    public void run()
    {
        /*
        long start = System.currentTimeMillis();
        while (!flag.getFlag())
        {

        }
        long end = System.currentTimeMillis();
        print("end - start: " + (end - start));
        */
        try {
            flag.Wait();
        } catch (InterruptedException e) {
            print("InterruptedException");
        }
        flag.setFlag(true);

    }
}

public class Test22 {
    public static void main(String[] args) throws Exception
    {
        Flag flag = new Flag();
        Task1 task1 = new Task1(flag);
        Task2 task2 = new Task2(flag);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(task1);
        exec.execute(task2);

        TimeUnit.SECONDS.sleep(10);
        exec.shutdown();
    }
}
