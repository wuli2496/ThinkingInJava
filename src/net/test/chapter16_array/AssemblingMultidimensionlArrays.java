package net.test.chapter16_array;

import java.util.*;
import static net.test.util.Print.*;

public class AssemblingMultidimensionlArrays {
    public static void main(String[] args)
    {
        Integer[][] a;
        a = new Integer[3][];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++)
            {
                a[i][j] = j * j;
            }
        }

        print(Arrays.deepToString(a));
    }
}
