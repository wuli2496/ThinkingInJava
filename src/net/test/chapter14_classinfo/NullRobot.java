package net.test.chapter14_classinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

class NullRobotProxyHandler implements InvocationHandler
{
    private String nullName;
    private Robot proxied = new NRobot();

    public NullRobotProxyHandler(Class<? extends Robot> type)
    {
        nullName = type.getSimpleName() + " NullRobot";
    }
    private class NRobot implements Null, Robot
    {
        public String name()
        {
            return nullName;
        }

        public String model()
        {
            return nullName;
        }

        public List<Operation> operations()
        {
            return Collections.emptyList();
        }

    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        return method.invoke(proxied, args);
    }
}

public class NullRobot
{
    public static Robot newNullRobot(Class<? extends Robot> type)
    {
        return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(), new Class[]{Null.class, Robot.class}, new NullRobotProxyHandler(type));
    }

    public static void main(String[] args)
    {
        Robot[] robots = {new SnowRemovalRobot("SnowBee"), newNullRobot(SnowRemovalRobot.class)};
        for (Robot r : robots)
        {
            Robot.Test.test(r);
        }
    }
}
