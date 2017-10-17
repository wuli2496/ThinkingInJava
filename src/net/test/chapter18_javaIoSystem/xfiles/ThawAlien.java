package net.test.chapter18_javaIoSystem.xfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ThawAlien {
    public static void main(String[] args) throws Exception
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("F:\\my_git_hub\\ThinkingInJava", "X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
