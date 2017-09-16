package net.test.chapter16_array;

import java.util.*;
import net.test.util.*;
import static net.test.util.Print.*;

public class Reverse {
    public static void main(String[] args)
    {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        print("Before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        print("After sorting:");
        print(Arrays.toString(a));
    }
}
