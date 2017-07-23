package net.test.chapter14_classinfo.example;

import net.test.chapter14_classinfo.HiddenImplementation;

import static net.test.util.Print.*;

class InnerA
{
    private static class C implements  A
    {
        public void f() {print("public C.f()");}
        public void g() { print("public C.g()");}
        void u() {print("package C.u()");}
        protected void v() {print("protected C.v()");}
        private void w() {print("private C.w()");}
    }

    public static A makeA() { return new C();}
}

public class InnerImplementation {
    public static void main(String[] args) throws Exception
    {
        A a = InnerA.makeA();
        a.f();

        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }

}
