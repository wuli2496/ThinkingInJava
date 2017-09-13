package net.test.chapter16_array;

import net.test.util.*;
import static net.test.util.Print.*;

public class GeneratorTest {
    public static int size = 10;
    public static void test(Class<?> surroundingClass)
    {
        for (Class<?> type : surroundingClass.getClasses())
        {
            print(type.getSimpleName() + ": ");
            try {
                Generator<?> g = (Generator<?>)type.newInstance();
                for (int i = 0; i < size; i++)
                {
                    System.out.printf(g.next() + " ");
                }
                print();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args)
    {
        test(CountingGenerator.class);
    }
}
