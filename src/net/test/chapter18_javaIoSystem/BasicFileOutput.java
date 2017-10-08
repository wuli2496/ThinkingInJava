package net.test.chapter18_javaIoSystem;

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException
    {

        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("F:\\my_git_hub\\ThinkingInJava\\src\\net\\test\\chapter18_javaIoSystem\\BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        //FileWriter out = new FileWriter(file);
        int lineCount = 1;
        String s;

        long start = System.nanoTime();
        while ((s = in.readLine()) != null)
        {
            out.println(lineCount++ + ": "  + s);
        }
        out.close();
        long end = System.nanoTime();
        System.out.println("cost time: " + (end - start));
        //System.out.println(BufferedInputFile.read(file));

    }
}