package net.test.chapter18_javaIoSystem;

import static net.test.util.Print.*;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException
    {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
        print(in.readDouble());
        print(in.readUTF());
        print(in.readDouble());
        print(in.readUTF());
    }
}
