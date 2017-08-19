package net.test.chapter13_string;

import static net.test.util.Print.*;

public class Replacing {
    static String s = Splitting.knights;

    public static void main(String[] args)
    {
        print(s);
        print(s.replaceFirst("f\\w+", "located"));
        print(s.replaceAll("(shrubbery|tree|herring)", "banana"));
    }
}
