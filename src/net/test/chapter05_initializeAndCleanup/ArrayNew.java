package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;
import java.util.Random;
import java.util.Arrays;

public class ArrayNew {
    public static void main(String[] args)
    {
        int[] a;
        Random rand = new Random(47);
        a = new int[rand.nextInt(20)];
        print("length of a: " + a.length);
        print(Arrays.toString(a));
    }
}
