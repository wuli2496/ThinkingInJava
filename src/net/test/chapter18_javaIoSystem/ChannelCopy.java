package net.test.chapter18_javaIoSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException
    {
        if (args.length != 2)
        {
            System.out.println("arguments: sourcefile dstfile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1)
        {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }
}
