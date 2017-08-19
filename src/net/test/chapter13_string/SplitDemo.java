package net.test.chapter13_string;

import java.util.regex.Pattern;
import static net.test.util.Print.*;
import java.util.Arrays;

public class SplitDemo {
    public static void main(String[] args)
    {
        String input = "This!!unusual use!!of exclamation!!points";
        print(Arrays.toString(Pattern.compile("!!").split(input)));
        print(Arrays.toString(Pattern.compile("!!").split(input, 3)));
        print(Arrays.toString(input.split("!!")));
    }
}
