package net.test.chapter15_genericParadigm;

import net.test.chapter15_genericParadigm.watercolors.Watercolors;
import static net.test.util.Print.*;
import static net.test.util.Sets.*;
import static net.test.chapter15_genericParadigm.watercolors.Watercolors.*;
import java.util.Set;
import java.util.EnumSet;

public class WatercolorSets {
    public static void main(String[] args)
    {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULENA_BLUE_HUE, BURNT_UMBER);
        print("set1: " + set1);
        print("set2: " + set2);
        print("union(set1, set2): " + union(set1, set2));
        Set<Watercolors> subset = intersection(set1, set2);
        print("intersection(set1, set2): " + subset);
        print("difference(set1, subset): " + difference(set1, subset));
        print("difference(set2, subset): " + difference(set2, subset));
        print("complement(set1, set2): " + complement(set1, set2));
    }
}
