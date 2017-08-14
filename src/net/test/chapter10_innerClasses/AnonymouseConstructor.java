package net.test.chapter10_innerClasses;

import static net.test.util.Print.*;

abstract class Base
{
    public Base(int i)
    {
        print("Base Constructor, i = " + i);
    }

    public abstract void f();
}

public class AnonymouseConstructor {
    public static Base getBase(int i)
    {
        return new Base(i)
        {
            {
                print("Inside instancce initializer");
            }
          public void f()
          {
            print("In anonymout f()");
          }
        };
    }

    public static void main(String[] args)
    {
        Base base = getBase(47);
        base.f();
    }
}
