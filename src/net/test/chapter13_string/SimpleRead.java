package net.test.chapter13_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.IOException;
import static net.test.util.Print.*;

public class SimpleRead {
    public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));

    public static void main(String[] args)
    {
        try {
            print("What is your name?");
            String name = input.readLine();
            print(name);
            print("How old ar you? What is you favorite double?");
            print("(input: <age> <double>");
            String numbers = input.readLine();
            print(numbers);
            String[] numArray = numbers.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.format("Hi %s\n", name);
            System.out.format("In 5 years you will be %d.\n", age + 5);
            System.out.format("My favorite double is %f.", favorite / 2);
        }  catch (IOException e) {
            System.err.println("I/O Exception");
        }
    }
}
