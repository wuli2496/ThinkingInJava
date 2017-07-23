package net.test.chapter03_operator;

import static net.test.util.Print.*;
import java.util.*;

public class MathOps {
    public static void main(String[] args)
    {
        Random rand = new Random(47);
        int i, j, k;
        j = rand.nextInt(100) + 1;
        print("j: " + j);
        k = rand.nextInt(100) + 1;
        print("k: " + k);
        i = j + k;
        print("j + k: " + i);
        i = j - k;
        print("j - k:" + i);
        i = j / k;
        print("j / k: " + i);
        i = j * k;
        print("j * k: "  + i);
        i = j % k;
        print("j % k: " + i);

        float u, v, w;
        v = rand.nextFloat();
        print("v: " + v);
        w = rand.nextFloat();
        print("w: " + w);
        u = v + w;
        print("v + w: " + u);
        u = v - w;
        print("v - w: " + u);
        u = v * w;
        print("v * w:" + u);
        u = v / w;
        print("v / w:" + u);

        u += v;
        print("u += v: " + u);
        u -= v;
        print("u -= v: " + u);
        u *= v;
        print("u *= v: " + u);
        u /= v;
        print("u /= v: " + u);
    }
}
