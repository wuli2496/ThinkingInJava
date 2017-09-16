package net.test.chapter16_array;

import java.util.*;
import static net.test.util.Print.*;

class A
{
    private int i;
    public A(int j)
    {
        i = j;
    }


    @Override
    public boolean equals(Object b)
    {
        if (this == b) return true;
        if (b == null) return false;

        if (getClass() != b.getClass()) return false;

        A tmp = (A)b;

        return i == tmp.i;
    }
}

public class ComparingArrays {
    public static void main(String[] args)
    {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1, 47);
        Arrays.fill(a2, 47);
        print(Arrays.equals(a1, a2));

        a2[3] = 11;
        print(Arrays.equals(a1, a2));

        String[] s1 = new String[4];
        Arrays.fill(s1, "Hi");
        String[] s2 = {new String("Hi"), new String("Hi"), new String("Hi"), new String("Hi")};
        print(Arrays.equals(s1, s2));

        A[] a = new A[10];
        A[] b = new A[10];
        Arrays.fill(a, new A(1));
        Arrays.fill(b, new A(1));
        print(Arrays.equals(a, b));

        int[][] inta = {{1, 2, 3}, {4, 5, 6}};
        int[][] intb = {{1, 2, 3}, {4, 5, 6}};
        print(Arrays.deepEquals(inta, intb));
    }

}
