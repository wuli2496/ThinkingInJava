package net.test.chapter16_array;

import java.util.Arrays;

import static net.test.util.Print.*;

public class MultidemensionalPrimitiveArray {
    public static void main(String[] args)
    {
        int[][] a = {{1,2,3},{4,5,6}};
        print(Arrays.deepToString(a));
    }
}
