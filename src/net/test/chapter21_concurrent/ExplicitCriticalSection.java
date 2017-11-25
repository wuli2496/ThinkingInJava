package net.test.chapter21_concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExplicitPairManager1 extends PairManager
{
    private Lock lock = new ReentrantLock();

    public synchronized void increment()
    {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

class ExplicitPairManager2 extends PairManager
{
    private Lock lock = new ReentrantLock();

    public void increment()
    {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }

        store(temp);
    }
}

public class ExplicitCriticalSection {
    public static void main(String[] args)
    {
        PairManager pm1 = new ExplicitPairManager1(), pm2 = new ExplicitPairManager2();
        CriticalSection.testApproches(pm1, pm2);
    }
}
