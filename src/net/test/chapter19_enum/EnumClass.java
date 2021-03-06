package net.test.chapter19_enum;

import static net.test.util.Print.print;
import static net.test.util.Print.printnb;

enum Shrubbery {GROUND, CRAWLING, HANGING}

public class EnumClass {
    public static void main(String[] args)
    {
        for (Shrubbery s : Shrubbery.values())
        {
            print(s + " ordinal: " + s.ordinal());
            printnb(s.compareTo(Shrubbery.CRAWLING) + " ");
            printnb(s.equals(Shrubbery.CRAWLING) + " ");
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass());
            print(s.name());
            print("-------------------------");
        }

        for (String s : "HANGING CRAWLING GROUND".split(" "))
        {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            print(shrub);
        }
    }
}
