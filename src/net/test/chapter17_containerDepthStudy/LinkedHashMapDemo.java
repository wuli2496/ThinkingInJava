package net.test.chapter17_containerDepthStudy;

import java.util.*;
import net.test.util.*;
import static net.test.util.Print.*;

public class LinkedHashMapDemo {
    public static void main(String[] args)
    {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(new CountingMapData(9));
        print(linkedMap);

        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));
        print(linkedMap);

        for (int i = 0; i < 6; i++)
        {
            linkedMap.get(i);
        }

        print(linkedMap);
        linkedMap.get(0);
        print(linkedMap);
    }
}
