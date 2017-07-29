package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;
import java.util.Random;
import java.util.Arrays;

public class ArrayClassObj {
    public static void main(String[] args)
    {
        Random rand = new Random(47);
        Integer[] a;
        a = new Integer[rand.nextInt(20)];
        print("length of a: " + a.length);

        for (int i = 0; i < a.length; i++)
        {
            a[i] = rand.nextInt(500);
        }


        print(Arrays.toString(a));
    }
}
