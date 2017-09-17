package net.test.chapter17_containerDepthStudy;

import net.test.util.CollectionData;
import net.test.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;
import static net.test.util.Print.*;

class Government implements Generator<String>
{
    String[] foundation = ("strange women lying in ponds " + "distributing swords is no basis for a system of " + "government").split(" ");
    private int index;
    public String next()
    {
        return foundation[index++];
    }
}

public class CollectionDataTest {
    public static void main(String[] args)
    {
        Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(), 15));
        print(set);
        set.addAll(CollectionData.list(new Government(), 15));
        print(set);
    }
}
