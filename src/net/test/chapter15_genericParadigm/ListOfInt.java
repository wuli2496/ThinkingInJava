package net.test.chapter15_genericParadigm;

import java.util.*;

public class ListOfInt {
    public static void main(String[] args)
    {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            li.add(i);
        }

        for (int i : li)
        {
            System.out.println(i);
        }
    }
}
