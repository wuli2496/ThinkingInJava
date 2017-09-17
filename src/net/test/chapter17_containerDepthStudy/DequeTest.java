package net.test.chapter17_containerDepthStudy;

import net.test.util.Deque;

import static net.test.util.Print.*;

public class DequeTest {
    static void fillTest(Deque<Integer> deque)
    {
        for (int i = 20; i < 27; i++)
        {
            deque.addFirst(i);
        }

        for (int i = 50; i < 55; i++)
        {
            deque.addLast(i);
        }
    }

    public static void main(String[] args)
    {
        Deque<Integer> di = new Deque<Integer>();
        fillTest(di);
        print(di);
        fillTest(di);
        while (di.size() != 0)
        {
            printnb(di.removeLast() + " ");
        }
    }
}
