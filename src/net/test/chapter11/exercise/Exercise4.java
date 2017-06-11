package net.test.chapter11.exercise;

import java.util.*;
import static net.test.util.Print.*;

/**
 * Created by John on 2017/6/11.
 */

class Generator
{
    private static String[] movies = {"Snow White", "Star Wars"};
    private int cur = 0;

    public boolean hasNext()
    {
        return cur != movies.length;
    }

    public String next()
    {
        return movies[cur++];
    }
}

public class Exercise4 {
    static Collection fill(Collection<String> collection)
    {
        Generator gen = new Generator();
        while (gen.hasNext())
        {
            collection.add(gen.next());
        }

        return collection;
    }
    public static void main(String[] args)
    {
        print(fill(new ArrayList<String>()));
        print(fill(new LinkedList<String>()));
        print(fill(new HashSet<String>()));
        print(fill(new LinkedHashSet<String>()));
        print(fill(new TreeSet<String>()));
    }
}
