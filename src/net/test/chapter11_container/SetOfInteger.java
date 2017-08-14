package net.test.chapter11_container;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class SetOfInteger {
    public static void display(Iterator<Integer> iter)
    {
        while (iter.hasNext())
        {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<Integer>();
        for (int i = 0; i < 10000; i++)
        {
            intset.add(rand.nextInt(30));
        }

        //System.out.println(intset);
        display(intset.iterator());

    }
}
