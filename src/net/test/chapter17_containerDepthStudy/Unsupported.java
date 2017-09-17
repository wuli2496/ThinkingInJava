package net.test.chapter17_containerDepthStudy;

import java.util.*;
import static net.test.util.Print.*;

public class Unsupported {
    static void test(String msg, List<String> list)
    {
        print("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        Collection<String> c2 = new ArrayList<String>(subList);
        try {
            c.retainAll(c2);
        } catch (Exception e) {
            print("retainAlll():" + e);
        }

        try {
            c.removeAll(c2);
        } catch (Exception e) {
            print("removeAll(): " + e);
        }

        try {
            c.clear();
        } catch (Exception e) {
            print("clear(): " + e);
        }

        try {
            c.add("X");
        } catch (Exception e) {
            print("add(): " + e);
        }

        try {
            c.addAll(c2);
        } catch (Exception e) {
            print("addAll(): " + e);
        }

        try {
            c.remove("C");
        } catch (Exception e) {
            print("remove(): " + e);
        }

        try {
            list.set(0, "X");
        } catch (Exception e) {
            print("List.set(): " + e);
        }
    }

    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
        test("unmodifiedList()" , Collections.unmodifiableList(new ArrayList<String>(list)));
    }
}
