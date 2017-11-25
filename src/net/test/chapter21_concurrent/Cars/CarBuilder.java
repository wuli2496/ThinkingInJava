package net.test.chapter21_concurrent.Cars;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

import static net.test.util.Print.print;

class Car
{
    private final int id;
    private boolean engine = false, driveTrain = false, wheels = false;

    public Car(int idn) {id = idn;}
    public Car() {id = -1;}

    public synchronized int getId() {return id;}
    public synchronized void addEngine() {engine = true;}
    public synchronized void addDriveTrain() { driveTrain = true;}
    public synchronized void addWheels() {wheels =  true;}
    public synchronized String toString()
    {
        return "Car " + id + " [engine" + engine + " driveTrain: " + driveTrain + " wheels: " + wheels + "]";
    }
}

class CarQueue extends LinkedBlockingQueue<Car> {}

class ChassisBuilder implements Runnable
{
    private CarQueue carQueue;
    private int counter = 0;

    public ChassisBuilder(CarQueue q) {carQueue = q;}

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                TimeUnit.MILLISECONDS.sleep(500);
                Car c = new Car(counter++);
                print("ChassisBuilder created " + c);
                carQueue.put(c);
            }
        } catch (InterruptedException e) {
            print("Interrupted: ChassisBuilder");
        }

        print("ChassisBuilder off");
    }
}

class Assembler implements Runnable
{
    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private RobotPool robotPool;

    public Assembler(CarQueue cq, CarQueue fq, RobotPool rp)
    {
        chassisQueue = cq;
        finishingQueue = fq;
        robotPool = rp;
    }

    public Car car() {return car;}

    public CyclicBarrier barrier() {return barrier;}

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                car = chassisQueue.take();
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                barrier.await();
                finishingQueue.put(car);
            }
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            print("Exiting Assembler via interrupte");
        }

        print("Assembler off");
    }
}

class Reporter implements Runnable
{
    private CarQueue carQueue;
    public Reporter(CarQueue q) {carQueue = q;}

    public void run()
    {
        try {
            while (!Thread.interrupted()) {
                print(carQueue.take());
            }
        } catch (InterruptedException e) {
            print("Exiting Reporter via interrupt");
        }

        print("Reporter off");
    }
}

abstract class Robot implements Runnable
{
    private RobotPool pool;
    public Robot(RobotPool p) {pool = p;}
    protected Assembler assembler;

    public Robot assignAssembler(Assembler assembler)
    {
        this.assembler = assembler;
        return this;
    }
    private boolean engage = false;

    public synchronized void engage()
    {
        engage = true;
        notifyAll();
    }

    abstract protected void performService();

    public void run()
    {
        try {
            powerDown();

            while (!Thread.interrupted())
            {
                performService();
                assembler.barrier().await();
                powerDown();
            }
        } catch (InterruptedException e) {
            print("Exiting " + this + " vai interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        print(this + " off");
    }

    private synchronized void powerDown() throws InterruptedException
    {
        engage = false;
        assembler = null;
        pool.release(this);
        while (engage == false) wait();
    }

    public String toString()
    {
        return getClass().getName();
    }
}

class EngineRobot extends Robot
{
    public EngineRobot(RobotPool pool) {super(pool);}
    protected void performService()
    {
        print(this + " installing engine");
        assembler.car().addEngine();
    }
}

class DriveTrainRobot extends Robot
{
    public DriveTrainRobot(RobotPool pool) {super(pool);}
    protected void performService()
    {
        print(this + " installing DriverTrain");
        assembler.car().addDriveTrain();
    }
}

class WheelRobot extends Robot
{
    public WheelRobot(RobotPool pool) {super(pool);}
    protected void performService()
    {
        print(this + " installing Wheel");
        assembler.car().addWheels();
    }
}

class RobotPool
{
    private Set<Robot> pool = new HashSet<>();
    public synchronized void add(Robot r)
    {
        pool.add(r);
        notifyAll();
    }

    public synchronized void hire(Class<? extends Robot> robotType, Assembler d) throws InterruptedException
    {
        for (Robot r: pool)
        {
            if (r.getClass().equals(robotType))
            {
                pool.remove(r);
                r.assignAssembler(d);
                r.engage();
                return;
            }
        }

        wait();
        hire(robotType, d);
    }

    public synchronized void release(Robot r)
    {
        add(r);
    }
}
public class CarBuilder {
    public static void main(String[] args) throws Exception
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        CarQueue chasisQueue = new CarQueue(), finishingQueue = new CarQueue();
        RobotPool robotPool = new RobotPool();
        exec.execute(new EngineRobot(robotPool));
        exec.execute(new DriveTrainRobot(robotPool));
        exec.execute(new WheelRobot(robotPool));
        exec.execute(new Assembler(chasisQueue, finishingQueue, robotPool));
        exec.execute(new ChassisBuilder(chasisQueue));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }
}
