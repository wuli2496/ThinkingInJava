package net.test.chapter14_classinfo;

import net.test.chapter14_classinfo.example.*;
import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception
    {
        A a = HiddenC.makeC();

        a.f();
        System.out.println(a.getClass().getName());

        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    public static void callHiddenMethod(Object a, String methodName) throws Exception
    {
        Method method = a.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(a);
    }
}
