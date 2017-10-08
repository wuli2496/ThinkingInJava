package net.test.chapter18_javaIoSystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class FileLocking {
    public static void main(String[] args) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null)
        {
            System.out.println("Locked file");
            fl.release();
            System.out.println("Released Lock");
        }

        fos.close();
    }
}
