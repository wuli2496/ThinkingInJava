package net.test.chapter13_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.test.util.Print.*;
import net.test.util.TextFile;

/*! Here's a block of text to use as input to
    the regular expression matcher. Note that we'll
    first extract the block of text by looking for
    ther special delimiters, then process the
    extracted block.!*/
public class TheReplacements {
    public static void main(String[] args)
    {
        String s = TextFile.read("F:\\my_git_hub\\ThinkingInJava\\src\\net\\test\\chapter13_string\\TheReplacements.java");
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if (mInput.find())
        {
            s = mInput.group(1);
        }
        s = s.replaceAll(" {2,}", "");

        s = s.replaceAll("(?m)^ +", "");

        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        print(s);

        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while (m.find())
        {
            m.appendReplacement(sbuf, m.group().toUpperCase());
        }

        m.appendTail(sbuf);
        print(sbuf);

    }
}
