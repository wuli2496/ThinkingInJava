package net.test.chapter15_genericParadigm;

class Other{}

class BaseOther extends BashHolder<Other>
{

}
public class Unconstrained {
    public static void main(String[] args)
    {
        BaseOther b = new BaseOther(), b2 = new BaseOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}
