package net.test.chapter21_concurrent.waxonmatix2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.test.util.Print.print;
import static net.test.util.Print.printnb;

class Car
{
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    private boolean waxOn = false;

    public void waxed()
    {
        lock.lock();
        try {
            waxOn = true;
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void buffed()
    {
        lock.lock();
        try {
            waxOn = false;
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitForWaxing() throws InterruptedException
    {
        lock.lock();
        try {
            while (waxOn == false) cond.await();
        } finally {
            lock.unlock();
        }
    }

    public void waitForBuffing() throws InterruptedException
    {
        lock.lock();
        try  {
            while (waxOn == true) cond.await();
        } finally {
            lock.unlock();
        }
    }
}

class WaxOn implements Runnable
{
    private Car car;

    public WaxOn(Car car)
    {
        this.car = car;
    }

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                printnb("Wax On!");
                TimeUnit.MILLISECONDS.sleep(100);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e){
            print("Exiting via Interrupt");
        }

        print("Ending wax on task");
    }
}

class WaxOff implements Runnable
{
    private Car car;
    public WaxOff(Car car)
    {
        this.car = car;
    }
    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                car.waitForWaxing();
                printnb("Wax off!");
                TimeUnit.MILLISECONDS.sleep(100);
                car.buffed();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");
        }

        print("Ending wax off task");
    }
}

public class WaxOnMatix2 {
    public static void main(String[] args) throws Exception
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        Car car = new Car();
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));

        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}
