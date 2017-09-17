package net.test.chapter17_containerDepthStudy;

import java.util.LinkedList;
import java.util.Stack;

import static net.test.util.Print.print;
import static net.test.util.Print.printnb;

enum Month
{
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEBER
}

public class Stacks {
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();
        for (Month m : Month.values())
        {
            stack.push(m.toString());
        }
        print("stack = " + stack);

        stack.addElement("The last time");
        print("element 5 = " + stack.elementAt(5));
        print("popping elements:");
        while (!stack.empty())
        {
            printnb(stack.pop() + " ");
        }

        LinkedList<String> lstack = new LinkedList<String>();
        for (Month m : Month.values())
        {
            lstack.addFirst(m.toString());
        }
        print("lstack = " + lstack);
        while (!lstack.isEmpty())
        {
            printnb(lstack.removeFirst() + " ");
        }

    }
}
