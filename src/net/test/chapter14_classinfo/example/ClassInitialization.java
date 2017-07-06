package net.test.chapter14_classinfo.example;

/**
 * Created by John on 2017/6/25.
 */
import static net.test.util.Print.*;
import java.util.*;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2
{
    static int staticNoFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3
{
    static int staticNoFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}


public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args)
    {
        Class initable = Initable.class;
        print("After creating initable ref");
        print(Initable.staticFinal);
        print(Initable.staticFinal2);

        print(Initable2.staticNoFinal);

        Class initable3 = null;
        try {
            initable3 = Class.forName("net.test.chapter14_classinfo.example.Initable3");
        } catch (ClassNotFoundException e) {
            print("not found class Initable3");
            System.exit(1);
        }

        print("After creating Initable3 ref");
        print(Initable3.staticNoFinal);

    }
}
