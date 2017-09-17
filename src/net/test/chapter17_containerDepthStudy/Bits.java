package net.test.chapter17_containerDepthStudy;

import java.util.BitSet;
import java.util.Random;

import static net.test.util.Print.print;

public class Bits {
    public static void printBitSet(BitSet b)
    {
        print("bits: " + b);
        StringBuilder bbits = new StringBuilder();
        for (int i = 0; i < b.size(); i++)
        {
            bbits.append(b.get(i) ? "1" : "0");
        }

        print("bit pattern: " + bbits);
    }

    public static void setBitSet(int value, int len)
    {
        BitSet bit = new BitSet();
        for (int i = len - 1; i >= 0; i--)
        {
            if (((1 << i) & value) != 0) bit.set(i);
            else bit.clear(i);
        }

        print("value: " + value);
        printBitSet(bit);
    }

    public static void main(String[] args)
    {
        Random rand = new Random(47);
        byte bt = (byte)rand.nextInt();
        setBitSet(bt, 8);

        short st = (short)rand.nextInt();
        setBitSet(st, 16);

        int it = rand.nextInt();
        setBitSet(it, 32);

        BitSet b127 = new BitSet();
        b127.set(127);
        print("set bit 127: " + b127);

        BitSet b255 = new BitSet();
        b255.set(255);
        print("set bit 255: " + b255);

        BitSet b1023 = new BitSet();
        b1023.set(1023);
        b1023.set(1024);
        print("set bit 1023: " + b1023);
    }
}
