package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

class A {}

public class VarArgs {
    static void printArray(Object[] args)
    {
        for (Object obj: args)
        {
            printnb(obj + " ");
        }
        print();
    }

    public static void main(String[] args)
    {
        printArray(new Object[] {new Integer(47), new Float(3.14), new Double(11.11)});
        printArray(new Object[]{"one", "two", "three"});
        printArray(new Object[]{new A(), new A(), new A()});
    }
}
