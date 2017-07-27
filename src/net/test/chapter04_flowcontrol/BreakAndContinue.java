package net.test.chapter04_flowcontrol;

import static net.test.util.Print.*;
import static net.test.util.Range.*;

public class BreakAndContinue {
    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
        {
            if (i == 74) break;
            if (i % 9 != 0) continue;
            print(i + " ");
        }
        print();

        for (int i : range(100))
        {
            if (i == 74) break;
            if (i % 9 != 0) continue;
            print(i + " ");
        }

        print();

        int i = 0;
        while (true)
        {
            i++;
            int j = i * 27;
            if (j == 1269) break;
            if (i % 10 != 0) continue;
            print(i + " ");
        }
    }
}
