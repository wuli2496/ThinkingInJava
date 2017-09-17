package net.test.chapter17_containerDepthStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import static net.test.util.Print.print;

public class Enumerations {
    public static void main(String[] args)
    {
        Vector<String> v = new Vector<String>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements())
        {
            print(e.nextElement());
        }

        e = Collections.enumeration(new ArrayList<String>());
    }
}
