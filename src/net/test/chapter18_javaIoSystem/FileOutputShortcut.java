package net.test.chapter18_javaIoSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
    static String file = "FileOutputShortcut.out";
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("F:\\my_git_hub\\ThinkingInJava\\src\\net\\test\\chapter18_javaIoSystem\\FileOutputShortcut.java")));
        int lineCount = 1;
        PrintWriter out = new PrintWriter(file);
        String s;
        while ((s = in.readLine()) != null)
        {
            out.println(lineCount++ + ": " + s);
        }

        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
