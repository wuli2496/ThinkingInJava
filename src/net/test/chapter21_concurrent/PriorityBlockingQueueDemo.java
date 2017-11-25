package net.test.chapter21_concurrent;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;
import static net.test.util.Print.printnb;

class PrioritizedTask implements Runnable, Comparable<PrioritizedTask>
{
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    private Random rand = new Random(47);

    private static List<PrioritizedTask> sequences = new ArrayList<>();

    public PrioritizedTask(int priority)
    {
        this.priority = priority;
        sequences.add(this);
    }

    public void run()
    {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {

        }

        print(this);
    }

    public int compareTo(PrioritizedTask arg)
    {
        return arg.priority - priority;
    }

    public String toString()
    {
        return String.format("[%1$-3d]", priority) + " Task " + id;
    }

    public String summary()
    {
        return "(" + id + ": " + priority + ")";
    }

    public static class EndSentinel extends PrioritizedTask
    {
        private ExecutorService exec = Executors.newCachedThreadPool();

        public EndSentinel(ExecutorService e)
        {
            super(-1);
            exec = e;
        }

        public void run()
        {
            int count = 0;
            for (PrioritizedTask prioritizedTask: sequences)
            {
                printnb(prioritizedTask.summary());
                if (++count % 5 == 0) print();
            }
            print();
            print(this + " Calling shutdownNow");
            exec.shutdownNow();
        }
    }
}


class PrioritizedTaskProducer implements Runnable
{
    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PrioritizedTaskProducer(Queue<Runnable> q, ExecutorService e)
    {
        queue = q;
        exec = e;
    }

    public void run()
    {
        for (int i = 0; i < 20; i++)
        {
            queue.add(new PrioritizedTask(rand.nextInt(10)));
            Thread.yield();
        }

        try {
            for (int i = 0; i < 10; i++)
            {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }

            for (int i = 0; i < 10; i++)
            {
                queue.add(new PrioritizedTask(i));
            }

            queue.add(new PrioritizedTask.EndSentinel(exec));

        } catch (InterruptedException e) {

        }

        print("Finished PrioritizedTaskProducer");
    }
}

class PrioritizedTaskConsumer implements Runnable
{
    private PriorityBlockingQueue<Runnable> queue;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q)
    {
        queue = q;
    }

    public void run()
    {
        try {
            while (!Thread.interrupted())
            {
                queue.take().run();
            }
        } catch (InterruptedException e) {

        }

        print("Finished PrioritizedTaskConsumer");
    }
}

public class PriorityBlockingQueueDemo {
    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        exec.execute(new PrioritizedTaskProducer(queue, exec));
        exec.execute(new PrioritizedTaskConsumer(queue));

    }
}
