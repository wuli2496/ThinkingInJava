package net.test.chapter16_array;

import java.util.*;
import static net.test.util.Print.*;

public class MultiDimWrapperArray {
    public static void main(String[] args)
    {
        Integer[][] a1 = {{1, 2, 3}, {4, 5, 6}};
        Double[][] a2 = {{1.1, 2.2}, {3.3, 4.4}, {5.5, 6.6}, {7.7, 8.8}, {9.9, 1.2}, {2.3, 3.4}};
        String[][] a3 = {{"Ther", "Quick", "Sly", "Fox"}, {"Jumped", "Over"}, {"The", "Lazy", "Brown", "Dog", "and", "friend"}};
        print("a1: " + Arrays.deepToString(a1));
        print("a2: " + Arrays.deepToString(a2));
        print("a3: " + Arrays.deepToString(a3));
    }
}
