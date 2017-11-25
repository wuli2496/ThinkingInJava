package net.test.chapter21_concurrent;

public class FibonacciTest implements Runnable {
    private int n;

    public FibonacciTest(int n)
    {
        this.n = n;
    }

    private int fib(int n)
    {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public void run()
    {
        System.out.println("fib(" + n + "):" + fib(n));
    }

    public static void main(String[] args)
    {
        Thread t = new Thread(new FibonacciTest(10));
        t.start();
    }
}
