package net.test.chapter21_concurrent.exercise;

import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;

public class Interruptted {
    public static void main(String[] args) throws Exception
    {
        Thread t1 = new Thread() {
          public void run()
          {
              try {
                  TimeUnit.SECONDS.sleep(10);
              } catch(InterruptedException e) {
                  print("interruptedException");
                  print("interrupted: " + Thread.currentThread().isInterrupted());
              }
          }
        };
        t1.start();

        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
    }
}
