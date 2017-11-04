package net.test.chapter20_annotation;

import net.test.util.OSExecute;
import net.test.util.atunit.Test;

public class AtUnitExample1 {
    public String methodOne()
    {
        return "This is methodOne";
    }

    public int methodTwo()
    {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    boolean methodOneTest()
    {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean m2()
    {
        return methodTwo() == 2;
    }

    @Test
    private boolean m3()
    {
        return true;
    }

    @Test
    boolean failureTest()
    {
        return true;
    }

    @Test
    boolean anotherDisappointment()
    {
        return false;
    }

    public static void main(String[] args) throws Exception
    {
        OSExecute.command("java net.test.util.atunit.AtUnit AtUnitExample1");
    }
}
