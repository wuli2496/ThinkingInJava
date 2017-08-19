package net.test.chapter13_string;


import net.test.util.Match;

public class exercise10 {
    public static void main(String[] args)
    {
        String s = "Java now has regular expressions";
        String[] patterns = {"^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}", "s{0,3}"};

        for (String pattern : patterns)
        {
            Match.match(s, pattern);
        }

    }
}
