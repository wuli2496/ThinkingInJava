package net.test.chapter16_array;

import java.util.*;
import net.test.util.*;
import static net.test.util.Print.*;

public class CompType implements Comparable<CompType> {
    int i, j;
    private static int count = 1;

    public CompType(int n1, int n2)
    {
        i = n1;
        j = n2;
    }

    public String toString()
    {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0)
        {
            result += "\n";
        }

        return result;
    }

    public int compareTo(CompType b)
    {
        return (i < b.i) ? -1 : (i == b.i ? 0 : 1);
    }

    private static  Random r = new Random();
    public static Generator<CompType> generator()
    {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }

    public static void main(String[] args)
    {
        CompType[] a = Generated.array(new CompType[12], generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a);
        print("after sorting:");
        print(Arrays.toString(a));

    }
}
