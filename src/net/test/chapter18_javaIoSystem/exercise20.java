package net.test.chapter18_javaIoSystem;

import net.test.util.BinaryFile;
import net.test.util.Directory;

import java.io.File;
import java.io.IOException;

import static net.test.util.Print.print;

public class exercise20 {
    public static void main(String[] args) throws IOException
    {
        Directory.TreeInfo files = Directory.walk("F:\\my_git_hub\\ThinkingInJava\\out\\production\\ThinkingInJava\\net\\test\\chapter18_javaIoSystem", ".*\\.class$");
        for (File file: files.files)
        {
            StringBuilder sb = new StringBuilder();
            byte[] data = BinaryFile.read(file);

            for (int i = 0; i < 4; i++)
            {
                int a = Byte.toUnsignedInt(data[i]);
                sb.append(Integer.toHexString(a));
            }

            print("s: " + sb.toString() + " = " + sb.toString().equalsIgnoreCase("CAFEBABE"));
        }
    }
}
