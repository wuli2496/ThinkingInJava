package net.test.chapter18_javaIoSystem;

import net.test.util.Directory;
import net.test.util.PPrint;

import java.io.File;

import static net.test.util.Print.print;

public class DirectoryDemo {
    public static void main(String[] args)
    {
        PPrint.pprint(Directory.walk(".").dirs);

        for (File file: Directory.local(".", "T.*"))
        {
            print(file);
        }

        print("-----------------");
        for (File file : Directory.walk(".", "T.*\\.java"))
        {
            print(file);
        }

        print("===================");
        for (File file : Directory.walk(".", ".*[Zz].*\\.class"))
        {
            print(file);
        }
    }
}
