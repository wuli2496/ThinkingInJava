package net.test.chapter21_concurrent;

import static net.test.util.Print.print;

public class MultiLock {
    public synchronized void f1(int count)
    {
        if (count-- > 0)
        {
            print("f1() calling f2() with count " + count);
            f2(count);
        }
    }

    public synchronized void f2(int count)
    {
        if (count-- > 0)
        {
            print("f2() calling f1() with count " + count);
            f1(count);
        }
    }

    public static void main(String[] args)
    {
        MultiLock multiLock = new MultiLock();
        new Thread() {
            public void run()
            {
                multiLock.f1(10);
            }
        }.start();
    }
}
