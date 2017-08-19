package net.test.chapter13_string;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static net.test.util.Print.*;

public class MatchrMethods {
    public static void main(String[] args)
    {
        String s = "bcabcabcdef";
        String pattern = "abc";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        boolean match = m.lookingAt();
        print(match);
    }
}
