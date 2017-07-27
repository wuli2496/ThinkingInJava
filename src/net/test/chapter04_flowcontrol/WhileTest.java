package net.test.chapter04_flowcontrol;

import static net.test.util.Print.*;

public class WhileTest {

    static boolean condition()
    {
        boolean result = Math.random() < 0.99;
        print(result + ", ");
        return result;
    }

    public static void main(String[] args)
    {
        while (condition())
        {
            print("Inside 'while'");
        }
        print("Exited 'while'");
    }
}
