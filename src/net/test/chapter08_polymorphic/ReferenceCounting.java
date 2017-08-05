package net.test.chapter08_polymorphic;

import static net.test.util.Print.*;

class Shared
{
    private int refCount = 0;
    private static long count = 0;
    private final long id = ++count;

    public Shared()
    {
        print("Creating " + this);
    }

    public void addRef() {refCount++;}
    public void dispose()
    {
        if (--refCount == 0)
        {
            print("Disposing " + this);
        }
    }
    public String toString()
    {
        return "Shared " + id;
    }
}

class Composing
{
    private Shared shared;
    private static long count = 0;
    private final long id = ++count;

    public Composing(Shared shared)
    {
        print("Creating " + this);
        this.shared = shared;
        shared.addRef();
    }

    public String toString()
    {
        return "Composing " + id;
    }

    public void dispose()
    {
        print("Disposing " + this);
        shared.dispose();
    }
}

public class ReferenceCounting {
    public static void main(String[] args)
    {
        Shared shared = new Shared();
        Composing[] composings = {new Composing(shared), new Composing(shared),
                                    new Composing(shared), new Composing(shared),
                                    new Composing(shared)};

        for (Composing composing : composings)
        {
            composing.dispose();
        }
    }
}
