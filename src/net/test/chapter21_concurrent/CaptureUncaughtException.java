package net.test.chapter21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static net.test.util.Print.print;

class ExceptionThread2 implements Runnable
{
    public void run()
    {
        Thread t = Thread.currentThread();
        print("run() by " + t);
        print("eh=" + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
{
    public void uncaughtException(Thread t, Throwable e)
    {
        print("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory
{
    public Thread newThread(Runnable r)
    {
        print(this + " creating new Thread");
        Thread t = new Thread(r);
        print("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        print("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {
    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
        exec.shutdown();
    }
}
