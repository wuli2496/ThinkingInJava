package net.test.chapter13_string;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;

public class ReplacingStringTokenizer {
    public static void main(String[] args)
    {
        String input = "But I'm not dead yet! I feel happy!";
        StringTokenizer stoken = new StringTokenizer(input);
        while (stoken.hasMoreElements())
        {
            System.out.print(stoken.nextToken() + " ");
        }
        System.out.println();

        System.out.println(Arrays.toString(input.split(" ")));
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext())
        {
            System.out.print(scanner.next() + " ");
        }
        System.out.println();
    }
}
