package net.test.chapter18_javaIoSystem;

import java.nio.ByteBuffer;

import static net.test.util.Print.print;
import static net.test.util.Print.printnb;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args)
    {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);

        int i = 0;
        while (i++ < bb.limit())
        {
            if (bb.get() != 0)
            {
                print("nonzero");
            }
        }

        print("i = " + i);
        bb.rewind();

        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0)
        {
            printnb(c + " ");
        }
        print();
        bb.rewind();

        bb.asShortBuffer().put((short)471142);
        print(bb.getShort());
        bb.rewind();

        bb.asIntBuffer().put(99471142);
        print(bb.getInt());
        bb.rewind();

        bb.asLongBuffer().put(99471142);
        print(bb.getLong());
        bb.rewind();

        bb.asFloatBuffer().put(99471142);
        print(bb.getFloat());
        bb.rewind();

        bb.asDoubleBuffer().put(99471142);
        print(bb.getDouble());
        bb.rewind();
    }
}
