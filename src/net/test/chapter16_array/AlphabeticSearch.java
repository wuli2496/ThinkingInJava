package net.test.chapter16_array;

import java.util.*;
import net.test.util.*;
import static net.test.util.Print.*;

public class AlphabeticSearch {
    public static void main(String[] args)
    {
        String[] a = Generated.array(new String[30], new RandomGenerator.String(5));
        Arrays.sort(a, String.CASE_INSENSITIVE_ORDER);
        print(Arrays.toString(a));
        int index = Arrays.binarySearch(a, a[10], String.CASE_INSENSITIVE_ORDER);
        print("index: " + index + "\n" + a[index]);
    }
}
