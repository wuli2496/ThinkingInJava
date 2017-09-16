package net.test.chapter16_array;

import java.util.*;
import net.test.util.*;
import static net.test.util.Print.*;

class CompTypeComparator implements Comparator<CompType>
{
    public int compare(CompType a1, CompType a2)
    {
        return a1.i < a2.i ? -1 : (a1.i == a2.i ? 0 : 1);
    }
}

public class ComparatorTest {
    public static void main(String[] args)
    {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a, new CompTypeComparator());
        print("after sorting:");
        print(Arrays.toString(a));
    }
}
