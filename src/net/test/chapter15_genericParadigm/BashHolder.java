package net.test.chapter15_genericParadigm;

public class BashHolder<T> {
    private T element;
    public void set(T arg)
    {
        element = arg;
    }

    public T get()
    {
        return element;
    }

    public void f()
    {
        System.out.println(element.getClass().getSimpleName());
    }
}
