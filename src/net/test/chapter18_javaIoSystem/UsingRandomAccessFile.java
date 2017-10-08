package net.test.chapter18_javaIoSystem;

import java.io.IOException;
import java.io.RandomAccessFile;

import static net.test.util.Print.print;

public class UsingRandomAccessFile {
    static String file = "rtest.dat";
    static void display() throws IOException
    {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++)
        {
            print("Value " + i + ": " + rf.readDouble());
        }
        print(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException
    {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++)
        {
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(5 * 8);;
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
