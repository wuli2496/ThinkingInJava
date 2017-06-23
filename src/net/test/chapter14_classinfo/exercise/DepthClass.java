package net.test.chapter14_classinfo.exercise;

/**
 * Created by John on 2017/6/23.
 */
import java.lang.reflect.Field;

import static net.test.util.Print.*;

class Base
{
    int a;
}

class Derived extends Base
{
    int b;
}


public class DepthClass {
    public static void printInfo(Class c)
    {
        if (c == null) return;

        print("name: " + c.getName());
        print("simple name: " + c.getSimpleName());
        print("canonical name: " + c.getCanonicalName());
        for(Field field : c.getDeclaredFields())
        {
            print("field:" + field.getName());
        }

        printInfo(c.getSuperclass());
    }
    public static void main(String[] args)
    {

        printInfo(Derived.class);
    }
}
