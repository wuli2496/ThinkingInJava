package net.test.chapter06.exercise;

import static net.test.util.Print.*;

/**
 * Created by John on 2017/4/8.
 */

class Exercise5_test
{
    public int m_p1;
    protected int m_p2;
    int m_p3;
    private int m_p4;

    public void p1()
    {
        print(m_p1);
    }

    protected void p2()
    {
        print(m_p2);
    }

    void p3()
    {
        print(m_p3);
    }

    private void p4()
    {
        print(m_p4);
    }
}
public class Exercise5 {
    public static void main(String[] args)
    {
        Exercise5_test x = new Exercise5_test();
        print(x.m_p1);
        print(x.m_p2);
        print(x.m_p3);
        x.p1();
        x.p2();
        x.p3();
    }
}
