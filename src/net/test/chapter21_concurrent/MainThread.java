package net.test.chapter21_concurrent;

public class MainThread {
    public static void main(String[] args)
    {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
