package net.test.chapter15_genericParadigm;

import java.util.*;

public class GenericWriting {
    static <T> void writeExact(List<T> list, T item)
    {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruits = new ArrayList<Fruit>();

    static void f1()
    {
        writeExact(apples, new Apple());
        writeExact(fruits, new Apple());
    }

    static <T> void writewithWildcard(List<? super T> list, T item)
    {
        list.add(item);
    }

    static void f2()
    {
        writewithWildcard(apples, new Apple());
        writewithWildcard(fruits, new Apple());
    }

    public static void main(String[] args)
    {
        f1();
        f2();
    }
}
