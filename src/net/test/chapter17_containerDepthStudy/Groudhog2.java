package net.test.chapter17_containerDepthStudy;

public class Groudhog2 extends Groundhog {
    public Groudhog2(int n)
    {
        super(n);
    }

    public int hashCode()
    {
        return number;
    }

    public boolean equals(Object o)
    {
        return o instanceof Groudhog2 && number == ((Groudhog2)o).number;
    }
}
