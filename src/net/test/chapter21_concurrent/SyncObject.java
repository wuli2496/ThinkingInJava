package net.test.chapter21_concurrent;

import static net.test.util.Print.print;

class DuralSynch
{
    private Object syncObject = new Object();
    public synchronized void f()
    {
        for (int i = 0; i < 5; i++)
        {
            print("f()");
            Thread.yield();
        }
    }

    public void g()
    {
        synchronized (syncObject)
        {
            for (int i = 0; i < 5; i++)
            {
                print("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args)
    {
        final DuralSynch ds = new DuralSynch();
        new Thread() {
            public void run()
            {
                ds.f();
            }
        }.start();
        ds.g();
    }
}
