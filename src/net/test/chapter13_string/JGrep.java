package net.test.chapter13_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.test.util.Print.*;
import net.test.util.TextFile;

public class JGrep {
    public static void main(String[] args) throws Exception
    {
        if (args.length < 2)
        {
            print("Usage: java JGrep file regex");
            System.exit(0);
        }

        Pattern p = Pattern.compile(args[1]);
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : new TextFile(args[0]))
        {
            m.reset(line);
            while (m.find())
            {
                print(index++ + ": " + m.group() + ": " + m.start());
            }
        }
    }
}
