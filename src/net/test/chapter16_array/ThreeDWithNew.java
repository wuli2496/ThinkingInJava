package net.test.chapter16_array;

import java.util.Arrays;

import static net.test.util.Print.*;

public class ThreeDWithNew {
    public static void main(String[] args)
    {
        int[][][] a = new int[2][2][4];
        print(Arrays.deepToString(a));
    }
}
