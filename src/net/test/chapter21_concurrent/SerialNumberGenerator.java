package net.test.chapter21_concurrent;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static synchronized int nextSerialNumber()
    {
        return serialNumber++;
    }
}
