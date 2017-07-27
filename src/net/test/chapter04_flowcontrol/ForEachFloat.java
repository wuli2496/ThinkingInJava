package net.test.chapter04_flowcontrol;

import java.util.Random;
import static net.test.util.Print.*;


public class ForEachFloat {
    public static void main(String[] args)
    {
        Random rand = new Random(47);
        float[] f = new float[10];
        for (int i = 0; i < 10; i++)
        {
            f[i] = rand.nextFloat();
        }

        for (float x : f)
        {
            print(x);
        }
    }
}
