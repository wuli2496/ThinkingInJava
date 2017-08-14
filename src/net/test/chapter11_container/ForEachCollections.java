package net.test.chapter11_container;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Collections;

public class ForEachCollections {
    public static void main(String[] args)
    {
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for (String s : cs)
        {
            System.out.print("'" + s + "' ");
        }
    }
}
