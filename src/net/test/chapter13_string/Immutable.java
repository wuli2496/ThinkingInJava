package net.test.chapter13_string;

import static net.test.util.Print.*;

public class Immutable {
    public static String upcase(String s)
    {
        return s.toUpperCase();
    }

    public static void main(String[] args)
    {
        String q = "howdy";
        print(q);
        String qq = upcase(q);
        print(qq);
        print(q);
    }
}
