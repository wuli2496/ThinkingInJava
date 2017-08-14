package net.test.chapter11_container;

import java.util.ArrayList;

class Apple
{
    private static long counter;
    private final long id = counter++;
    public long id() {return id;}
}

class Orange {}

public class AppleAndOrangeWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 3; i++)
        {
            apples.add(new Apple());
        }

        for (int i = 0; i < apples.size(); i++)
        {
            ((Apple)apples.get(i)).id();
        }
    }
}
