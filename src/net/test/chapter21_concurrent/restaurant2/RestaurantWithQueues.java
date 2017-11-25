package net.test.chapter21_concurrent.restaurant2;

import net.test.chapter19_enum.menu.Course;
import net.test.chapter19_enum.menu.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static net.test.util.Print.print;

class Order
{
    private static int counter = 0;
    private final int id = counter++;
    private final Customer customer;
    private final Food food;
    private final WaitPerson waitPerson;

    public Order(Customer cust, WaitPerson wp, Food f)
    {
        customer = cust;
        waitPerson = wp;
        food = f;
    }

    public Food item()
    {
        return food;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public WaitPerson getWaitPerson() {
        return waitPerson;
    }

    public String toString()
    {
        return "Order: " + id + " itme: " + food + " for: " + customer + " served by: " + waitPerson;
    }
}

class Plate
{
    private final Order order;
    private final Food food;

    public Plate(Order or, Food f)
    {
        order = or;
        food = f;
    }

    public Order getOrder() {
        return order;
    }

    public Food getFood() {
        return food;
    }

    public String toString()
    {
        return food.toString();
    }
}

class Customer implements Runnable
{
    private static int counter = 0;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    public Customer(WaitPerson w)
    {
        waitPerson = w;
    }

    public void deliver(Plate p) throws InterruptedException
    {
        placeSetting.put(p);
    }

    public void run()
    {
        for (Course course : Course.values())
        {
            Food food = course.randomSelect();
            try {
                waitPerson.placeOrder(this, food);
                print(this + " eating " + placeSetting.take());
            } catch (InterruptedException e) {
                print(this + " waiting for " + course + " interrupted");
                break;
            }
        }

        print(this + " finished meal, leaving");
    }

    public String toString()
    {
        return "Customer " + id + " ";
    }
}

class WaitPerson implements Runnable
{
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    BlockingQueue<Plate> filedOrders = new LinkedBlockingQueue<>();

    public WaitPerson(Restaurant rest)
    {
        restaurant = rest;
    }

    public void placeOrder(Customer cust, Food food)
    {
        try {
            restaurant.orders.put(new Order(cust, this, food));
        } catch (InterruptedException e) {
            print(this + " placeOrder interrupted");
        }
    }

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                Plate plate = filedOrders.take();
                print(this + "received " + plate + " delivering to" + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            print(this + " interrupted");
        }

        print(this + " off duty");
    }

    public String toString()
    {
        return "WaitPerson " + id + " ";
    }
}

class Chef implements Runnable
{
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restanrant;
    private static Random rand = new Random(47);

    public Chef(Restaurant rest)
    {
        restanrant = rest;
    }

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                Order order = restanrant.orders.take();
                Food requestedItem = order.item();
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                Plate plate = new Plate(order, requestedItem);
                order.getWaitPerson().filedOrders.put(plate);
            }
        } catch (InterruptedException e) {
            print(this + " interrupted");
        }

        print(this +  " off duty");
    }

    public String toString()
    {
        return "Chef " + id + " ";
    }
}

class Restaurant implements Runnable
{
    private List<WaitPerson> waitPersons = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService exec;
    private static Random rand = new Random(47);
    BlockingQueue<Order> orders = new LinkedBlockingQueue<>();

    public Restaurant(ExecutorService e, int nWaitPerson, int nChefs)
    {
        exec = e;
        for (int i = 0; i < nWaitPerson; i++)
        {
            WaitPerson waitPerson = new WaitPerson(this);
            waitPersons.add(waitPerson);
            exec.execute(waitPerson);
        }

        for (int i = 0; i < nChefs; i++)
        {
            Chef chef = new Chef(this);
            chefs.add(chef);
            exec.execute(chef);
        }
    }
    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                WaitPerson wp = waitPersons.get(rand.nextInt(waitPersons.size()));
                Customer c = new Customer(wp);
                exec.execute(c);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            print("Restaurant interrupted");
        }

        print("Restaurant closing");
    }
}
public class RestaurantWithQueues {
    public static void main(String[] args) throws Exception
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(exec, 5, 2);
        exec.execute(restaurant);
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
