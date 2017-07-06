package net.test.chapter14_classinfo.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.test.util.Print.*;

/**
 * Created by John on 2017/7/6.
 */
class MethodSelector implements InvocationHandler
{
    private Object proxied;

    public MethodSelector(Object proxied)
    {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        if (method.getName().equals("intersting"))
        {
            print("Proxy detected the interesting method");
        }

        return method.invoke(proxied, args);
    }
}

interface SomeMethohs
{
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}

class Implementation implements SomeMethohs
{
    public void boring1()
    {
        print("boring1");
    }

    public void boring2()
    {
        print("boring2");
    }

    public void interesting(String arg)
    {
        print("interestring " + arg);
    }

    public void boring3()
    {
        print("boring3");
    }
}

public class SelectingMethods
{
    public static void main(String[] args)
    {
        SomeMethohs proxy = (SomeMethohs) Proxy.newProxyInstance(SomeMethohs.class.getClassLoader(), new Class[]{SomeMethohs.class}, new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
}
