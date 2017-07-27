package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

class Person
{
    public void eat(Apple apple)
    {
        Apple peeled = apple.getPeeled();
        print("Yummy");
    }
}

class Peeler
{
    static Apple peel(Apple apple)
    {
        return apple;
    }
}

class Apple
{
    Apple getPeeled()
    {
        return Peeler.peel(this);
    }
}

public class PassingThis {
    public static void main(String[] args)
    {
        new Person().eat(new Apple());
    }
}
