package net.test.chapter21_concurrent;

class UnresponseUI
{
    private volatile double d = 1;
    public UnresponseUI() throws Exception
    {
        while (d > 0)
        {
            d = d + (Math.PI + Math.E) / d;
        }
        System.in.read();
    }
}

public class ResponseUI extends Thread{
    private static volatile double d = 1;
    public ResponseUI()
    {
        setDaemon(true);
        start();
    }

    public void run()
    {
        while (true)
        {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception
    {
        new ResponseUI();
        System.in.read();
        System.out.println(d);
    }
}
