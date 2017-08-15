package net.test.chapter12_exceptionProcess;

import static net.test.util.Print.*;

public class ExceptionMethods {
    public static void main(String[] args)
    {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            print("Caught Exception");
            print("getMessage(): " + e.getMessage());
            print("getLocalizedMessage(): " + e.getLocalizedMessage());
            print("toString(): " + e);
            print("printStackTrace: ");
            e.printStackTrace();
        }
    }
}
