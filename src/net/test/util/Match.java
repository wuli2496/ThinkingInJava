package net.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.test.util.Print.print;

public class Match {
    public static void match(String s, String pattern)
    {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        print("------------------------------------");
        print("text: " + s + " pattern: " + pattern);
        while (m.find())
        {
            print("match: " + m.group() + " at position start: " + m.start() + "-" + (m.end() - 1));
        }
        print("-------------------------------------");
    }
}
