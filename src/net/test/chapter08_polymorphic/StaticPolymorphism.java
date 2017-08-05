package net.test.chapter08_polymorphic;

import static net.test.util.Print.*;

class StaticSuper
{
    public static String staticGet()
    {
        return "StaticSuper staticGet";
    }

    public String dynamicGet()
    {
        return "StaticSuper dynamicGet";
    }
}

class StaticSub extends StaticSuper
{
    public static String staticGet()
    {
        return "StaticSub staticGet";
    }

    public String dynamicGet()
    {
        return "StaticSub dynamicGet";
    }
}

public class StaticPolymorphism {
    public static void main(String[] args)
    {
        StaticSuper sup = new StaticSub();
        print(sup.staticGet());
        print(sup.dynamicGet());
    }
}
