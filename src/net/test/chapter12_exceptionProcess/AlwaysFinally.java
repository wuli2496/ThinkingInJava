package net.test.chapter12_exceptionProcess;

import static net.test.util.Print.*;

class FourException extends Exception {}

public class AlwaysFinally {
    public static void main(String[] args)
    {
        print("Entering first try block");
        try {
            print("Entering second try block");
            try {
                throw new FourException();
            }  finally {
                print("finally in 2nd try block");
            }
        } catch (FourException e) {
            print("Caught FourException in 1st try block");
        } finally {
            print("finally in 1st try block");
        }
    }
}
