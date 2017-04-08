package net.test.chapter06.exercise;

import static net.test.util.Print.print;

/**
 * Created by John on 2017/4/8.
 */

class Cookie
{
    public Cookie()
    {
        print("Cookie constructor");
    }

    protected void bite()
    {
        print("bite");
    }
}

public class Exercise4 {
    public static void main(String[] args)
    {
        Cookie x = new Cookie();
        x.bite();
    }
}
