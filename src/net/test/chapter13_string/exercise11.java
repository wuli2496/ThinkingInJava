package net.test.chapter13_string;


import net.test.util.Match;

public class exercise11 {

    public static void main(String[] args)
    {
        String p = "(?i)((^[aeiou])|(\\s[aeiou]))\\w+?[aeiou]\\b";
        String s = "Arline ate eight apples and one orange while Anita hadn't any";

        Match.match(p, s);
    }
}
