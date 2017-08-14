package net.test.chapter11_container;

import java.util.TreeSet;
import java.util.Random;
import java.util.Set;

public class SortedSetOfInteger {
    public static void main(String[] args)
    {
        Random rand = new Random(47);
        Set<Integer> intset = new TreeSet<>();
        for (int i = 0; i < 10000; i++)
        {
            intset.add(rand.nextInt(30));
        }

        System.out.println(intset);
    }
}
