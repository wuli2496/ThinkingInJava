package net.test.chapter06_accessAuthorityControl.exercise;

/**
 * Created by John on 2017/4/8.
 */

class Exercise6_test
{
    protected String s;
    private Exercise6_test(String s) {
        this.s = s;
    }

    public static Exercise6_test makeTest(String s)
    {
        return new Exercise6_test(s);
    }
}
public class Exercise6 {
    public static void main(String[] args)
    {
        Exercise6_test x = Exercise6_test.makeTest("hello");
    }
}
