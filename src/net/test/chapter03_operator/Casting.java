package net.test.chapter03_operator;


public class Casting {
    public static void main(String[] args)
    {
        int i = 200;
        long lng = i;
        lng = i;
        long lng2 = 200;
        i = (int)lng2;
    }
}
