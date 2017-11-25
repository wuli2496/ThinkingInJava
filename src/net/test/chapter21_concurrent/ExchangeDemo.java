package net.test.chapter21_concurrent;

import net.test.util.BasicGenerator;
import net.test.util.Generator;

import java.util.List;
import java.util.concurrent.*;

import static net.test.util.Print.print;

class ExchangeProducer<T> implements Runnable
{
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    ExchangeProducer(Exchanger<List<T>> exchg, Generator<T> gen, List<T> holder)
    {
        exchanger = exchg;
        generator = gen;
        this.holder = holder;
    }

    public void run()
    {
        try {
            while(Thread.interrupted())
            {
                for (int i = 0; i < ExchangeDemo.size; i++)
                {
                    holder.add(generator.next());
                }

                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {

        }
    }
}

class ExchangerConsumer<T> implements Runnable
{
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder)
    {
        exchanger = ex;
        this.holder = holder;
    }

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                holder = exchanger.exchange(holder);
                for (T x : holder)
                {
                    value = x;
                    holder.remove(x);
                }
            }
        } catch (InterruptedException e) {

        }

        print("Final value " + value);
    }
}

public class ExchangeDemo {
    static int size = 10;
    static int delay = 5;


    public static void main(String[] args) throws Exception
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
        List<Fat> producerList = new CopyOnWriteArrayList<>(), consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangeProducer<Fat>(xc, BasicGenerator.create(Fat.class), producerList));
        exec.execute(new ExchangerConsumer<Fat>(xc, consumerList));

        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
