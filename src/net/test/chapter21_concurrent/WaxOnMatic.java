package net.test.chapter21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;
import static net.test.util.Print.printnb;

class Car
{
    private boolean waxOn = false;

    public synchronized void waxed()
    {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed()
    {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException
    {
        while (waxOn == false)
            wait();
    }

    public synchronized void waitForBuffing() throws InterruptedException
    {
        while (waxOn == true) wait();
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
                TimeUnit.MILLISECONDS.sleep(200);
                car.waitForBuffing();
                car.waxed();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");

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
                printnb("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupted");
        }

        print("Ending Wax off task");
    }
}
public class WaxOnMatic {
    public static void main(String[] args) throws Exception
    {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
