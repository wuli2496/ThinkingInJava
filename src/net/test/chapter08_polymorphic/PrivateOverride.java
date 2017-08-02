package net.test.chapter08_polymorphic;

import net.test.util.Print;

import static net.test.util.Print.*;

public class PrivateOverride {
    private void f()
    {
        print("private f()");
    }

    public static void main(String[] args)
    {
        PrivateOverride po = new Derived();
        po.f();
    }
}


class Derived extends PrivateOverride
{
    public void f()
    {
        print("public f()");
    }
}