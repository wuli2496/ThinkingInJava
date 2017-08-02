package net.test.chapter07_reusingClass;

import static net.test.util.Print.*;

class WaterSource
{
    private String s;

    WaterSource()
    {
        print("WaterSource()");
        s = "Constructor";
    }

    public String toString() {return s;}
}

public class SprinklerSystem {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    public String toString()
    {
        return "valve1 = " + valve1 + " " +
                "valve2 = " + valve2 + " " +
                "valve3 = " + valve3 + " " +
                "valve4 = " + valve4 + " " +
                "i = " + i + " " +
                "f = " + f + " " +
                "source = " + source;
    }

    public static void main(String[] args)
    {
        SprinklerSystem sprinkler = new SprinklerSystem();
        print(sprinkler);
    }
}
