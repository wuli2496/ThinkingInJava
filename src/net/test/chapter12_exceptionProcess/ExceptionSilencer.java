package net.test.chapter12_exceptionProcess;

public class ExceptionSilencer {
    public static void main(String[] args)
    {
        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}
