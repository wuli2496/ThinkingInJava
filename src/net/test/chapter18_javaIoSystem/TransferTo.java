package net.test.chapter18_javaIoSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2)
        {
            System.out.println("arguments: sourcefile dstfile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel(), out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
    }
}
