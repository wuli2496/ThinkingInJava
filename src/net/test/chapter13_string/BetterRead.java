package net.test.chapter13_string;

import java.util.Scanner;
import static net.test.util.Print.*;

public class BetterRead {
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(SimpleRead.input);
        String name = stdin.nextLine();
        print(name);
        print("How old are you? What is your favorite double?");
        print("(input: <age> <double>)");
        int age = stdin.nextInt();
        double favorite = stdin.nextDouble();

        System.out.format("Hi %s\n", name);
        System.out.format("In 5 years you will be %d.\n", age + 5);
        System.out.format("My favorite double is %f.", favorite / 2);
    }

}
