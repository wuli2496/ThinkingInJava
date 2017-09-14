package net.test.chapter16_array;

import net.test.util.CountingGenerator;
import net.test.util.Generated;

import java.util.Arrays;

import static net.test.util.Print.*;

public class TestGenerated {
    public static void main(String[] args)
    {
        Integer[] a = {9, 8, 7, 6};
        print(Arrays.toString(a));

        a = Generated.array(a, new CountingGenerator.Integer());
        print(Arrays.toString(a));

        Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        print(Arrays.toString(b));
    }
}
