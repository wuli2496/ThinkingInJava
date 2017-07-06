package net.test.chapter14_classinfo.example;

/**
 * Created by John on 2017/6/25.
 */
import static net.test.util.Print.*;

interface Interface
{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface
{
    public void doSomething()
    {
        print("doSomething");
    }

    public void somethingElse(String arg)
    {
        print("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface
{
    private Interface proxied;
    public SimpleProxy(Interface proxied)
    {
        this.proxied = proxied;
    }


    public void doSomething()
    {
        print("SimpleProxy doSomething");
        proxied.doSomething();
    }

    public void somethingElse(String arg)
    {
        print("SimpleProxy somethingElse");
        proxied.somethingElse(arg);
    }
}
public class SimpleProxyDemo {

    public static void consumer(Interface inteface)
    {
        inteface.doSomething();
        inteface.somethingElse("bonobo");
    }
    public static void main(String[] args)
    {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
