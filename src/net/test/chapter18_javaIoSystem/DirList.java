package net.test.chapter18_javaIoSystem;

import net.test.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import static net.test.util.Print.print;

class DirFilter implements FilenameFilter
{
    private Pattern pattern;
    public DirFilter(String regex)
    {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name)
    {
        try {
            String fileName = dir.getCanonicalPath() + File.separator + name;
            File file =  new File(fileName);
            if (!file.isFile()) return false;
            print(file.length());
            return pattern.matcher(TextFile.read(fileName)).find();
        } catch (Exception e) {

        }

        return pattern.matcher(name).matches();
    }
}

public class DirList {
    public static void main(String[] args)
    {
        File path = new File("F:\\my_git_hub\\ThinkingInJava\\src\\net\\test\\chapter18_javaIoSystem");
        String[] list;
        if (args.length == 0) list = path.list();
        else
            list = path.list(new DirFilter(args[0]));

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
        {
            print(dirItem);
        }
    }
}
