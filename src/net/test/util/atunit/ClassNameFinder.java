package net.test.util.atunit;

import net.test.util.BinaryFile;
import net.test.util.Directory;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static net.test.util.Print.print;

public class ClassNameFinder {
    public static String thisClass(byte[] classBytes)
    {
        Map<Integer, Integer> offsetTable = new HashMap<>();
        Map<Integer, String> classNameTable = new HashMap<>();

        try {
            DataInputStream data = new DataInputStream(new ByteArrayInputStream(classBytes));
            int magic = data.readInt();
            int minorVersion = data.readShort();
            int majorVersion = data.readShort();
            int constant_pool_count = data.readShort();
            int[] constant_pool = new int[constant_pool_count];
            for (int i = 1; i < constant_pool_count; i++)
            {
                int tag = data.read();
                int tableSize;
                switch (tag)
                {
                    case 1:
                        int length = data.readShort();
                        char[] bytes = new char[length];
                        for (int k = 0; k < bytes.length; k++)
                        {
                            bytes[k] = (char)data.read();
                        }
                        String className = new String(bytes);
                        classNameTable.put(i, className);
                        break;
                    case 5:
                    case 6:
                        data.readLong();
                        i++;
                        break;
                    case 7:
                        int offset = data.readShort();
                        offsetTable.put(i, offset);
                        break;
                    case 8:
                        data.readShort();
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        data.readInt();
                        break;
                    default:
                        throw new RuntimeException("Bad tag " + tag);
                }
            }
            short access_flag = data.readShort();
            int this_class = data.readShort();
            int super_class = data.readShort();
            return classNameTable.get(offsetTable.get(this_class)).replace("/", ".");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception
    {
        if (args.length > 0)
        {
            for (String arg : args)
            {
                print(thisClass(BinaryFile.read(new File(arg))));
            }
        }
        else
        {
            for (File klass : Directory.walk(".", ".*\\.class"))
            {
                print(thisClass(BinaryFile.read(klass)));
            }
        }
    }
}
