package net.test.chapter21_concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.test.util.Print.print;

class BlockedMutex
{
    private Lock lock = new ReentrantLock();
    public BlockedMutex()
    {
        lock.lock();
    }

    public void f()
    {
        try {
            lock.lockInterruptibly();
            print("lock acquired in f()");
        } catch (InterruptedException e) {
            print("Interrupated from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable
{
    BlockedMutex mutex = new BlockedMutex();

    public void run()
    {
        print("waiting for f() in BlockedMutex");
        mutex.f();
        print("Broken out of blocked call");
    }
}

public class Interrupting2 {
    public static void main(String[] args) throws Exception
    {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        print("Issuing t.interrupt()");
        t.interrupt();
    }
}
