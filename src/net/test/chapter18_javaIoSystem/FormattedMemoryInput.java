package net.test.chapter18_javaIoSystem;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException
    {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("F:\\my_git_hub\\ThinkingInJava\\src\\net\\test\\chapter18_javaIoSystem\\FormattedMemoryInput.java").getBytes()));
            while (true)
            {
                System.out.print((char)in.readByte());
            }
        } catch (EOFException e) {
            System.err.println("End of Stream");
        }
    }
}
