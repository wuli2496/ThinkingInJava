package net.test.chapter03_operator;

public class Precedence {
    public static void main(String[] args)
    {
        int x = 1, y = 2, z = 3;
        int a = x + y - 2 /2 + z;
        int b = x + (y - 2) / (z + 2);
        System.out.println("a = " + a + " b = " + b);
    }
}
