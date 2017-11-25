package net.test.chapter21_concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FibonacciCallableTest implements Callable<Integer> {

    private int n;
    public FibonacciCallableTest(int n) {this.n = n;}

    private int fib(int n)
    {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public Integer call()
    {
        return fib(n);
    }

    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> rets = new ArrayList<>();
        for (int i = 1; i < 3; i++)
        {
            rets.add(exec.submit(new FibonacciCallableTest(i)));
        }

        int sum = 0;
        for (Future<Integer> f : rets)
        {
            try {
                sum += f.get();
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            }
        }

        System.out.println("sum:" + sum);
        exec.shutdown();
    }
}
