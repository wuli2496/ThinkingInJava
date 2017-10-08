package net.test.chapter18_javaIoSystem;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
    public static void main(String[] args) throws IOException
    {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("F:\\my_git_hub\\ThinkingInJava\\src\\net\\test\\chapter18_javaIoSystem\\TestEOF.java")));
        while (in.available() != 0)
        {
            System.out.print((char)in.readByte());
        }
    }
}
