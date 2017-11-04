package net.test.chapter20_annotation;

import net.test.util.atunit.Test;

public class AtUnitExternalTest extends AtUnitExample1 {
    @Test
    boolean _methodOne()
    {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo()
    {
        return methodTwo() == 2;
    }

}
