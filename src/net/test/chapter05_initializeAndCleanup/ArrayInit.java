package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;
import java.util.Arrays;

public class ArrayInit {
    public static void main(String[] args)
    {
        Integer[] a = {new Integer(1), new Integer(2), 3};
        Integer[] b = new Integer[] {new Integer(1), new Integer(2), 3};

        print(Arrays.toString(a));
        print(Arrays.toString(b));
    }
}


