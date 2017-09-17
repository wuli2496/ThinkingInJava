package net.test.chapter17_containerDepthStudy;

import java.util.*;
import net.test.util.*;
import static net.test.util.Print.*;

public class SortedMapDemo {
    public static void main(String[] args)
    {
        SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>(new CountingMapData(10));
        print(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        print(low);
        print(high);
        Iterator<Integer> it = sortedMap.keySet().iterator();
        for (int i = 0; i <= 6; i++)
        {
            if (i == 3) low = it.next();
            if (i == 6) high = it.next();
            else it.next();
        }

        print(low);
        print(high);
        print(sortedMap.subMap(low, high));
        print(sortedMap.headMap(high));
        print(sortedMap.tailMap(low));
    }
}
