package net.test.chapter19_enum;

import java.util.EnumSet;

import static net.test.chapter19_enum.AlarmPoints.*;
import static net.test.util.Print.*;

public class EnumSets {
    public static void main(String[] args)
    {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        print("noneOf:" + points);
        points.add(BATHROOM);
        print("add: " + points);

        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        points = EnumSet.allOf(AlarmPoints.class);
        print(points);

        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);

        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        print(points);

        points = EnumSet.complementOf(points);
        print(points);
    }
}
