package net.test.chapter05_initializeAndCleanup;

import static net.test.util.Print.*;

public class PrimitiveOverloading {
    void f1(char c) {printnb("f1(char) ");}
    void f1(byte b) {printnb("f1(byte) ");}
    void f1(short s) {printnb("f1(short) ");}
    void f1(int i) {printnb("f1(int) ");}
    void f1(long l) {printnb("f1(long) ");}
    void f1(float f) {printnb("f1(float) ");}
    void f1(double d) {printnb("f1(double) ");}

    void f2(byte b) {printnb("f2(byte) ");}
    void f2(short s) {printnb("f2(short) ");}
    void f2(int i) {printnb("f2(int) ");}
    void f2(long l) {printnb("f2(long) ");}
    void f2(float f) {printnb("f2(float) ");}
    void f2(double d) {printnb("f2(double) ");}

    void f3(short s) {printnb("f3(short) ");}
    void f3(int i) {printnb("f3(int) ");}
    void f3(long l) {printnb("f3(long) ");}
    void f3(float f) {printnb("f3(float) ");}
    void f3(double d) {printnb("f3(double) ");}

    void f4(int i) {printnb("f4(int) ");}
    void f4(long l) {printnb("f4(long) ");}
    void f4(float f) {printnb("f4(float) ");}
    void f4(double d) {printnb("f4(double) ");}

    void f5(long l) {printnb("f5(long) ");}
    void f5(float f) {printnb("f5(float) ");}
    void f5(double d) {printnb("f5(double) ");}

    void f6(float f) {printnb("f6(float) ");}
    void f6(double d) {printnb("f6(double) ");}

    void f7(double d) {printnb("f7(double) ");}

    void testConstVal()
    {
        printnb("5: ");
        f1(5); f2(5); f3(5); f4(5); f5(5); f6(5); f7(5); print();
    }

    void testChar()
    {
        char x = 'x';
        printnb("char: ");
        f1(x); f2(x); f3(x); f4(x); f5(x); f6(x); f7(x); print();
    }

    void testByte()
    {
        byte x = 0;
        printnb("byte: ");
        f1(x); f2(x); f3(x); f4(x); f5(x); f6(x); f7(x); print();
    }

    void testShort()
    {
        short x = 0;
        printnb("short: ");
        f1(x); f2(x); f3(x); f4(x); f5(x); f6(x); f7(x); print();
    }

    void testInt()
    {
        int x = 0;
        printnb("int: ");
        f1(x); f2(x); f3(x); f4(x); f5(x); f6(x); f7(x); print();
    }

    void testLong()
    {
        long x = 0;
        printnb("long: ");
        f1(x); f2(x); f3(x); f4(x); f5(x); f6(x); f7(x); print();
    }

    void testFloat()
    {
        float x = 0;
        printnb("float: ");
        f1(x); f2(x); f3(x); f4(x); f5(x); f6(x); f7(x); print();
    }

    void testDouble()
    {
        double x = 0;
        printnb("double: ");
        f1(x); f2(x); f3(x); f4(x); f5(x); f6(x); f7(x); print();
    }

    public static void main(String[] args)
    {
        PrimitiveOverloading p = new PrimitiveOverloading();
        p.testConstVal();
        p.testChar();
        p.testByte();
        p.testShort();
        p.testInt();
        p.testLong();
        p.testFloat();
        p.testDouble();
    }
}
