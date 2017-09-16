package net.test.chapter16_array;

import net.test.util.RandomGenerator;
import net.test.util.*;
import java.util.*;
import static net.test.util.Print.*;

public class ArraySearching {
    public static void main(String[] args)
    {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
        Arrays.sort(a);
        print("Sorted array: " + Arrays.toString(a));
        while (true)
        {
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0)
            {
                print("Location of " + r + " is " + location + ", a[" + location + "] = " + a[location]);
                break;
            }
        }

        int[] b = {1, 2, 3};
        int res = Arrays.binarySearch(b, 4);
        print("res: " + res);

    }
}
