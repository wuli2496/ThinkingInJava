package net.test.chapter10_innerClasses;

import static net.test.util.Print.*;

public class Parcel1 {
    class Contents
    {
        private int i = 11;
        public int value() {return i;}
    }

    class Destination
    {
        private String label;
        Destination(String whereTo)
        {
            label = whereTo;
        }

        public String readLabel() {return label;}
    }

    public void ship(String dest)
    {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        print(d.readLabel());
    }

    public static void main(String[] args)
    {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
}
