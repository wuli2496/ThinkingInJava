package net.test.chapter21_concurrent;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;
import static net.test.util.Print.printnb;

class Customer
{
    private final int serviceTime;
    public Customer(int tm) {serviceTime = tm;}
    public int getServiceTime() {return serviceTime;}
    public String toString()
    {
        return "[" + serviceTime + "]";
    }
}

class CustomerLine extends ArrayBlockingQueue<Customer>
{
    public CustomerLine(int maxLineSize)
    {
        super(maxLineSize);
    }

    public String toString()
    {
        if (this.size() == 0) return "[Empty]";
        StringBuilder result = new StringBuilder();
        for (Customer customer : this)
        {
            result.append(customer);
        }

        return result.toString();
    }
}

class CustomerGenerator implements Runnable
{
    private CustomerLine customers;
    private static Random rand = new Random(47);

    public CustomerGenerator(CustomerLine cq)
    {
        customers = cq;
    }

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            print("CustomerGenerator interrupted");
        }

        print("CustomerGenerator terminating");
    }
}

class Teller implements Runnable, Comparable<Teller>
{
    private static int counter = 0;
    private final int id = counter++;

    private int customersServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;

    public Teller(CustomerLine cq)
    {
        customers = cq;
    }

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this) {
                    customersServed++;
                    while (!servingCustomerLine) wait();
                }
            }
        } catch (InterruptedException e) {
            print(this + " interrupted");
        }

        print(this + " ternimating");
    }

    public synchronized void doSomethingElse()
    {
        servingCustomerLine = false;
        customersServed = 0;
    }

    public synchronized void serveCustomerLine()
    {
        servingCustomerLine = true;
        notifyAll();
    }

    public synchronized int compareTo(Teller other)
    {
        return customersServed - other.customersServed;
    }

    public String toString()
    {
        return "Teller " + id + " ";
    }

    public String shortString()
    {
        return "T" + id;
    }
}

class TellerManager implements Runnable
{
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellerDoingOtherThings = new LinkedList<>();
    private int adjumentPeriod;
    private static Random rand = new Random(47);
    private CustomerLine customers;
    private ExecutorService exec;

    public TellerManager(ExecutorService e, CustomerLine customers, int adjumentPeriod)
    {
        exec = e;
        this.customers = customers;
        this.adjumentPeriod = adjumentPeriod;
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }

    public void adjustTellerNumber()
    {
        if (customers.size() / workingTellers.size() > 2)
        {
            if (tellerDoingOtherThings.size() > 0)
            {
                Teller teller = tellerDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.add(teller);
                return;
            }
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }

        if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2)
        {
            reassignOneTeller();
        }

        if (customers.size() == 0)
        {
            while (workingTellers.size() > 1)
            {
                reassignOneTeller();
            }
        }
    }

    private void reassignOneTeller()
    {
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellerDoingOtherThings.offer(teller);
    }

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                TimeUnit.MILLISECONDS.sleep(adjumentPeriod);
                adjustTellerNumber();
                printnb(customers + "{");
                for (Teller teller : workingTellers)
                {
                    printnb(teller.shortString() + " ");
                }
                print("}");
            }
        } catch (InterruptedException e) {
            print(this + " interrupted");
        }

        print(this + " terminating");
    }

    public String toString()
    {
        return "TellerMangager";
    }
}

public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws Exception
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(customers));
        exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));

        if (args.length > 0)
        {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        }
        else
        {
            print("Press 'Enter' to quit");
            System.in.read();
        }

        exec.shutdownNow();
    }
}
