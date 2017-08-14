package net.test.chapter10_innerClasses;

class MNA
{
    private void f() {}
    class A
    {
        private void g() {}
        public class B
        {
            void h()
            {
                g();
                f();
            }
        }
    }
}

public class MutiNestingAccess {
    public static void main(String[] args)
    {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnab = mnaa.new B();
        mnab.h();
    }
}
