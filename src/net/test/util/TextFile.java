package net.test.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    public static String read(String fileName)
    {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = br.readLine()) != null)
                {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    public static void write(String fileName, String text)
    {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String splitter)
    {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) remove(0);
    }

    public TextFile(String fileName)
    {
        this(fileName, "\n");
    }

    public void write(String fileName)
    {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (String item : this)
                {
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)
    {
        String file = read("F:\\my_git_hub\\ThinkingInJava\\src\\net\\test\\util\\TextFile.java");
        write("text.txt", file);
        TextFile text = new TextFile("text.txt");
        text.write("test2.txt");
        TreeSet<String> words = new TreeSet<>(new TextFile("F:\\my_git_hub\\ThinkingInJava\\src\\net\\test\\util\\TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));
    }
}
