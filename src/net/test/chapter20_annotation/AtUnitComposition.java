package net.test.chapter20_annotation;

import net.test.util.atunit.Test;

public class AtUnitComposition {
    AtUnitExample1 testObject = new AtUnitExample1();

    @Test
    boolean _methodOne()
    {
        return testObject.methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo()
    {
        return testObject.methodTwo() == 2;
    }
}
