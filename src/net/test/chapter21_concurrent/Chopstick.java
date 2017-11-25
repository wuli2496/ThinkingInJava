package net.test.chapter21_concurrent;

public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException
    {
        while (taken == true) wait();
        taken = true;
    }

    public synchronized void drop() throws InterruptedException
    {
        taken = false;
        notifyAll();
    }
}
