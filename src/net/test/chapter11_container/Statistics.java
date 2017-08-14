package net.test.chapter11_container;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Statistics {
    public static void main(String[] args)
    {
        Random rand = new Random(47);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 10000; i++)
        {
            int tmp = rand.nextInt(20);
            Integer freq = m.get(tmp);
            m.put(tmp, freq == null ? 1 : freq + 1);
        }

        System.out.println(m);
    }
}
