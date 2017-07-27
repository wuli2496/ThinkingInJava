package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

public class Flower {
    int petalCount = 0;
    String s = "initial value";

    Flower(int petals)
    {
        petalCount = petals;
        print("Constructor w/ int arg only, petcalCount= " + petalCount);
    }

    Flower(String ss)
    {
        s = ss;
        print("Constructor w/ String arg only, s = " + ss);
    }

    Flower(String s, int petals)
    {
        this(petals);
        this.s = s;
        print("String & int args");
    }

    Flower()
    {
        this("hi", 47);
        print("default constructor (no args)");
    }

    void printPetalCount()
    {
        print("petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args)
    {
        Flower f = new Flower();
        f.printPetalCount();
    }
}
