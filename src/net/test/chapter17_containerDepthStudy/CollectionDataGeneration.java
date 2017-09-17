package net.test.chapter17_containerDepthStudy;

import net.test.util.*;
import static net.test.util.Print.*;
import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDataGeneration {
    public static void main(String[] args)
    {
        print(new ArrayList<String>(CollectionData.list(new RandomGenerator.String(9), 10)));
        print(new HashSet<Integer>(CollectionData.list(new RandomGenerator.Integer(), 10)));
    }
}
