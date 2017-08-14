package net.test.chapter11_container;

import net.test.chapter10_innerClasses.InheritInner;

import java.util.Collection;
import java.util.ArrayList;

public class SimpleCollection {
    public static void main(String[] args)
    {
        Collection<Integer> c = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            c.add(i);
        }

        for (Integer i : c)
        {
            System.out.println(i);
        }
    }
}
