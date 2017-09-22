package net.test.chapter18_javaIoSystem;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException
    {
        StringReader in = new StringReader(BufferedInputFile.read("F:\\my_git_hub\\ThinkingInJava\\src\\net\\test\\chapter18_javaIoSystem\\MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1)
        {
            System.out.print((char)c);
        }
    }
}
