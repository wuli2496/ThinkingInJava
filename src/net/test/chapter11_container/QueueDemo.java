package net.test.chapter11_container;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class QueueDemo {
    public static void printQ(Queue q)
    {
        while (q.peek() != null)
        {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Queue<Integer> q = new LinkedList<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++)
        {
            q.offer(rand.nextInt(i + 10));
        }

        printQ(q);

        Queue<Character> cq = new LinkedList<>();
        for (char c : "Brontosaurus".toCharArray())
        {
            cq.offer(c);
        }
        printQ(cq);
    }
}
