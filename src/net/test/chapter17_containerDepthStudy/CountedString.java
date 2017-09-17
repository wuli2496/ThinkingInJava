package net.test.chapter17_containerDepthStudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.test.util.Print.print;

public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    public CountedString(String str)
    {
        s = str;
        created.add(s);
        for (String s2 : created)
        {
            if (s2.equals(s))
            {
                id++;
            }
        }
    }

    public String toString()
    {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    public int hashCode()
    {
        int result = 17;
        result = result * 37 + s.hashCode();
        result = result * 37 + id;
        return result;
    }

    public boolean equals(Object o)
    {
        return o instanceof CountedString && s.equals(((CountedString)o).s) && id == (((CountedString)o).id);
    }

    public static void main(String[] args)
    {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++)
        {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }

        print(map);
        for (CountedString cstring : cs)
        {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }
    }
}
