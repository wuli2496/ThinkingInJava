package net.test.chapter14_classinfo.example;

import java.lang.reflect.Field;

class WithPrivateFinalFiled
{
    private int i = 1;
    private final String s = "I'm totally safe";
    private String s2 = "Am I safe?";
    public String toString()
    {
        return "i=" + i + "," + s + "," + s2;
    }
}

public class ModifyPrivateFields {
    public static void main(String[] args) throws Exception
    {
        WithPrivateFinalFiled pf = new WithPrivateFinalFiled();
        System.out.println(pf);

        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("f.get(pf)=" + f.get(pf));
        f.setInt(pf, 47);
        System.out.println(pf);


        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("f.get(pf)=" + f.get(pf));
        f.set(pf, "No, you'are not!");
        System.out.println(pf);

        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("f.get(pf)=" + f.get(pf));
        f.set(pf, "No, you're not!");
        System.out.println(pf);
    }
}
