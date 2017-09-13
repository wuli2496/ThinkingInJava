package net.test.chapter16_array;

import java.util.*;
import static net.test.util.Print.*;

public class RaggedArray {
    public static void main(String[] args)
    {
        Random rand = new Random(47);
        int[][][] a = new int[rand.nextInt(7)][][];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = new int[rand.nextInt(5)][];
            for (int j = 0; j < a[i].length; j++)
            {
                a[i][j] = new int[rand.nextInt(5)];
            }
        }

        print(Arrays.deepToString(a));
    }
}
