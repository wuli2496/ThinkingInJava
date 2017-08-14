package net.test.chapter10_innerClasses;

class Parcel4 {
    private class PContents implements Contents
    {
        private int i = 11;
        public int value()
        {
            return i;
        }
    }

    protected class PDestination implements Destination
    {
        private String label;

        private PDestination(String whereTo)
        {
            label = whereTo;
        }

        public String readLabel()
        {
            return label;
        }
    }

    public Destination destination(String s)
    {
        return new PDestination(s);
    }

    public Contents content()
    {
        return new PContents();
    }

    public void testAccessInnerPrivate()
    {
        PContents p = new PContents();
        System.out.println(p.i);
    }
}

public class TestParcel
{
    public static void main(String[] args)
    {
        Parcel4 p = new Parcel4();
        Contents c = p.content();
        Destination d = p.destination("Tasmania");
        p.testAccessInnerPrivate();
    }
}