package net.test.chapter13_string;

import java.util.List;
import java.util.ArrayList;

public class InfiniteRecursion {
    public String toString()
    {
        return " InfiniteRecusion " + super.toString() + "\n";
    }

    public static void main(String[] args)
    {
        List<InfiniteRecursion> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            list.add(new InfiniteRecursion());
        }
        System.out.println(list);
    }
}
