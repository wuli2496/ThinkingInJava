package net.test.chapter07_reusingClass;

import static net.test.util.Print.*;

class WithFinals
{
    private final void f() {print("WithFinal.f()");}
    private void g() {print("WithFinal.g()");}
}

class OverridingPrivate extends WithFinals{
    private final void f() {print("OverridingPrivate.f()");}

    private void g() {print("OverridingPrivate.g()");}
}

class OverridingPrivate2 extends OverridingPrivate
{
    public final void f() {print("OverridingPrivate2.f()");}
    public void g(){print("OverridingPrivate2.g()");}

}

public class FinalOverridingIllusion
{
    public static void main(String[] args)
    {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();

        OverridingPrivate op = op2;
        //op.f();
        //op.g();

        WithFinals wf = op2;
        //wf.f();
        //wf.g();
    }
}


