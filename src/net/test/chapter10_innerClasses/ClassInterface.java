package net.test.chapter10_innerClasses;

public interface ClassInterface {
    void howdy();
    class Test implements ClassInterface
    {
        public void howdy()
        {
            System.out.println("Howdy");
        }

        public static void main(String[] args)
        {
            new Test().howdy();
        }
    }
}
