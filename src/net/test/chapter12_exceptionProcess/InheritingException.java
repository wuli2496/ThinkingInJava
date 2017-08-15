package net.test.chapter12_exceptionProcess;

class SimpleException extends Exception {}

public class InheritingException {
    public void f() throws SimpleException
    {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args)
    {
        InheritingException sed = new InheritingException();
        try {
            sed.f();
        } catch (Exception e) {
            System.out.println("Caught it!");
        }
    }
}
