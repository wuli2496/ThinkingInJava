package net.test.chapter03_operator;

import static net.test.util.Print.*;

public class Literals {
    public static void main(String[] args)
    {
        int i1 = 0x2f;
        print("i1: " + Integer.toBinaryString(i1));
        int i2 = 0x2F;
        print("i2: " + Integer.toBinaryString(i2));
        int i3 = 0177;
        print("i3: " + Integer.toBinaryString(i3));
        char c = 0xffff;
        print("c: " + Integer.toBinaryString(c));
        byte b = 0x7f;
        print("b: " + Integer.toBinaryString(b));
        short s = 0x7fff;
        print("s: " + Integer.toBinaryString(s));
        long n1 = 200L;
        print("n1: " + Long.toBinaryString(n1));
        long n2 = 200l;
        print("n2: " + Long.toBinaryString(n2));
        long n3 = 200;
        print("n3: " + Long.toBinaryString(n3));
        float f1 = 1;
        float f2 = 1F;
        float f3 = 1f;
        double d1 = 1d;
        double d2 = 1D;

    }
}
