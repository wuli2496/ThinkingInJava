package net.test.chapter15_genericParadigm;

interface FactoryI<T>
{
    T create();
}

class Foo2<T>
{
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory)
    {
        x = factory.create();
    }
}

class IntegerFactory implements FactoryI<Integer>
{
    public Integer create()
    {
        return new Integer(0);
    }
}


class Widget
{
    public static class Factory implements FactoryI<Widget>
    {
        public Widget create()
        {
            return new Widget();
        }
    }
}
public class FactoryConstant {
    public static void main(String[] args)
    {
        new Foo2(new IntegerFactory());
        new Foo2(new Widget.Factory());
    }
}
