package net.test.chapter21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;
import static net.test.util.Print.printnb;

class Meal
{
    private final int orderNum;
    public Meal(int orderNum)
    {
        this.orderNum = orderNum;
    }

    public String toString()
    {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable
{
    private Restraurant restraurant;

    public WaitPerson(Restraurant restraurant)
    {
        this.restraurant = restraurant;
    }

    public void run()
    {
        try {
            while(!Thread.interrupted())
            {
                synchronized (this)
                {
                    while (restraurant.meal == null)
                    {
                        wait();
                    }
                }

                print("WaitPerson got " + restraurant.meal);

                synchronized (restraurant.chef)
                {
                    restraurant.meal = null;
                    restraurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable
{
    private int count;
    private Restraurant restraurant;

    public Chef(Restraurant restraurant)
    {
        this.restraurant = restraurant;
    }

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                synchronized (this)
                {
                    while(restraurant.meal != null) wait();
                }

                if (++count == 10)
                {
                    print("Out of food, closed");
                    restraurant.exec.shutdownNow();
                }

                printnb("Order up!");

                synchronized (restraurant.waitPerson)
                {
                    restraurant.meal = new Meal(count);
                    restraurant.waitPerson.notifyAll();
                }

                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}
public class Restraurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();

    Chef chef = new Chef(this);
    WaitPerson waitPerson = new WaitPerson(this);

    public Restraurant()
    {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args)
    {
        new Restraurant();
    }
}
