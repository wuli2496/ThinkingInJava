package net.test.chapter18_javaIoSystem;

import java.io.File;

import static net.test.util.Print.print;

public class MakeDirectories {
    public static void usage()
    {
        System.err.println("Usage:MakeDirectories path1 ...\n" +
        "Creates each path\n" +
        "Usage:MakeDirectories -d path1 ...\n" +
        "Deletes each path\n" +
        "Usage:MakeDirectories -r path1 path2\n" +
        "Renames from path1 to path2");
        System.exit(1);
    }

    private static void fileData(File f)
    {
        System.out.println("Absolute path: " + f.getAbsolutePath() +
        "\n can read: " + f.canRead() +
        "\n can write: " + f.canWrite() +
        "\n getName: " + f.getName() +
        "\n getParent: " + f.getParent() +
        "\n getPath: " + f.getPath() +
        "\n length: " + f.length() +
        "\n lastModified: " + f.lastModified());

        if (f.isFile())
        {
            System.out.println("It's a file");
        }
        else if (f.isDirectory())
        {
            System.out.println("It's a directory");
        }
    }

    public static void main(String[] args)
    {
        File f = new File("F:\\my_git_hub\\ThinkingInJava\\ThinkingInJava.iml");
        print(f.getPath());
        print(f.getParent());
        print(f.getName());
        /*
        if (args.length < 1) usage();
        if (args[0].equals("-r"))
        {
            if (args.length != 3)
            {
                usage();
            }
            File old = new File(args[1]), rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }

        int count = 0;
        boolean del = false;
        if (args[0].equals("-d"))
        {
            count++;
            del = true;
        }
        count--;
        while (++count < args.length)
        {
            File f = new File(args[count]);
            if (f.exists())
            {
                System.out.println(f + " exists");
                f.delete();
            }
            else
            {
                if (!del)
                {
                    f.mkdirs();
                    System.out.println("created " + f);
                }
            }
            fileData(f);
        }
        */
    }
}
