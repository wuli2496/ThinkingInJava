package net.test.chapter11.example;

import java.util.*;
/**
 * Created by John on 2017/6/11.
 */
public class SimpleCollection {
    public static void main(String[] args)
    {
        Collection<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
        {
            c.add(i);
        }

        for(Integer i : c)
        {
            System.out.print(i + ",");
        }
    }
}
