package net.test.chapter15_genericParadigm;

import net.test.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Time;
import java.util.*;
import static net.test.util.Tuple.*;

class MixinProxy implements InvocationHandler
{
    Map<String, Object> delegatesByMethod;
    public MixinProxy(TwoTuple<Object, Class<?>>... pairs)
    {
        delegatesByMethod = new HashMap<>();

        for (TwoTuple<Object, Class<?>> pair : pairs)
        {
            for (Method method : pair.second.getMethods())
            {
                String methodName = method.getName();
                if (!delegatesByMethod.containsKey(methodName))
                {
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    public static Object newInstance(TwoTuple... pairs)
    {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++)
        {
            interfaces[i] = (Class)pairs[i].second;
        }

        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}

public class DynamicProxyMixin {
    public static void main(String[] args)
    {
        Object mixin = MixinProxy.newInstance(tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class));
        Basic b = (Basic)mixin;
        TimeStamped t = (TimeStamped)mixin;
        SerialNumbered s = (SerialNumbered)mixin;
        b.set("hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
    }
}
