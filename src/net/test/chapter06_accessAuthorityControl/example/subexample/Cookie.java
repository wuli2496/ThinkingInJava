package net.test.chapter06_accessAuthorityControl.example.subexample;

import static net.test.util.Print.print;

/**
 * Created by John on 2017/4/8.
 */
public class Cookie {
    public Cookie()
    {
        print("Cookie constructor");
    }

    protected void bite()
    {
        print("bite");
    }
}
