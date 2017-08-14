package net.test.chapter11_container;

import java.util.Arrays;

public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> iter)
    {
        for (T t : iter)
        {
            System.out.print(t  + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        test(Arrays.asList(strings));
    }

}
