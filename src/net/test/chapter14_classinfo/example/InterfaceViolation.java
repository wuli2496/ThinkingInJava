package net.test.chapter14_classinfo.example;

class B implements A
{
    public void f() {}
    public void g() {}
}
public class InterfaceViolation {
    public static void main(String[] args)
    {
        A a = new B();
        a.f();

        System.out.println(a.getClass().getName());
        if (a instanceof B)
        {
            B b = (B)a;
            b.g();
        }
    }
}
