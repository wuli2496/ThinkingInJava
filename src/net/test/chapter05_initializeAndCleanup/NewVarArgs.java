package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

public class NewVarArgs {
    static void printArray(Object... args)
    {
        for(Object obj: args)
        {
            printnb(obj + " ");
        }
        print();
    }

    public static void main(String[] args)
    {
        printArray(new Integer(47), new Float(3.14), new Double(11.11));
        printArray("one", "two", "three");
        printArray(new A(), new A(), new A());
        printArray();
    }
}
