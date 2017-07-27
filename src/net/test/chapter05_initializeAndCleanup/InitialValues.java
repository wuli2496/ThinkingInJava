package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

public class InitialValues
{
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;

    void printInitialValues()
    {
        print("Date type Initial value");
        print("boolean   " + t);
        print("char " + c);
        print("byte " + b);
        print("short    " + s);
        print("int  " + i);
        print("long " + l);
        print("float    " + f);
        print("double   " + d);
        print("reference    " + reference);
    }

    public static void main(String[] args)
    {
        InitialValues v = new InitialValues();
        v.printInitialValues();
    }
}
