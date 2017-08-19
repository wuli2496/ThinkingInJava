package net.test.chapter13_string;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static net.test.util.Print.*;

public class Groups {
    static public final String POEM = "Twas brilling, and the slithy toves\n" +
            "Did gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock, my son,\n" +
            "The jaws that bite, the claws that caatch.\n" +
            "Beware the Jubjub bird, and shun\n" +
            "The frumious Bandersnatch.";

    public static void main(String[] args)
    {
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        while (m.find())
        {
            printnb("groupcount: " + m.groupCount() + " ");
            for (int j = 0; j <= m.groupCount(); j++)
            {
                printnb("[" + m.group(j) + "]");
            }
            print();
        }
    }
}
