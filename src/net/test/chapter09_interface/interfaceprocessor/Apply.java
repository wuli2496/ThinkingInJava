package net.test.chapter09_interface.interfaceprocessor;

import static net.test.util.Print.*;

public class Apply {
    public static void process(Processor p, Object s)
    {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
}
