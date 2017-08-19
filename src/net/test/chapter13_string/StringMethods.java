package net.test.chapter13_string;

import static net.test.util.Print.*;
import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args)
    {
        String s = "abcd";
        print(s.length());

        for (int i = 0; i < s.length(); i++)
        {
            printnb(s.charAt(i) + " ");
        }
        print();

        byte[] bytes = new byte[s.length()];
        s.getBytes(0, s.length(), bytes, 0);
        print(Arrays.toString(bytes));
        char[] chars = new char[s.length()];
        s.getChars(0, s.length(), chars, 0);
        print(Arrays.toString(chars));

        char[] charArray = s.toCharArray();
        print(Arrays.toString(charArray));

        print("abcd".equals(s));
        print("Abcd".equalsIgnoreCase(s));
        print("abcd".compareTo(s));
        print(s.contains("bc"));

        String tmp = "bd";
        print(s.regionMatches(1, tmp, 0, 1));
    }
}
