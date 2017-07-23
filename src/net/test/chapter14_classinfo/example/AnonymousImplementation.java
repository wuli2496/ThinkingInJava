package net.test.chapter14_classinfo.example;

import net.test.chapter14_classinfo.HiddenImplementation;

import static net.test.util.Print.*;

class AnonymousA
{
    public static A makeA()
    {
        return new A() {
            public void f() {print("public C.f()");}
            public void g() {print("public C.g()");}
            void u() {print("packate C.u()");}
            protected void v() {print("protected C.v()");}
            private void w() {print("private C.w()");}
        };
    }
}

public class AnonymousImplementation {

    public static void main(String[] args) throws Exception
    {
        A a = AnonymousA.makeA();
        a.f();

        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}
