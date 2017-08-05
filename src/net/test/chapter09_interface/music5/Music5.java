package net.test.chapter09_interface.music5;

import net.test.chapter08_polymorphic.Note;
import static net.test.util.Print.*;

interface Instrument
{
    int VALUE = 5;

    void play(Note n);
    void adjust();
}

class Wind implements Instrument
{
    public void play(Note n)
    {
        print(this + ".play() " + n);
    }

    public String toString()
    {
        return "Wind";
    }

    public void adjust()
    {
        print(this + " adjust()");
    }
}

class Percussion implements Instrument
{
    public void play(Note n)
    {
        print(this + ".play() " + n);
    }

    public String toString()
    {
        return "Percussion";
    }

    public void adjust()
    {
        print(this + " adjust()");
    }
}

class Stringed implements Instrument
{
    public void play(Note n)
    {
        print(this + ".play() " + n);
    }

    public String toString()
    {
        return "Stringed";
    }

    public void adjust()
    {
        print(this + " adjust()");
    }
}

class Brass extends Wind
{
    public String toString()
    {
        return "Brass";
    }
}

class Windwood extends Wind
{
    public String toString()
    {
        return "Windwood";
    }
}

public class Music5 {
    static void tune(Instrument i)
    {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e)
    {
        for (Instrument i : e)
        {
            tune(i);
        }
    }

    public static void main(String[] args)
    {
        Instrument[] instruments = {new Wind(), new Percussion(), new Stringed(), new Brass(), new Windwood()};
        tuneAll(instruments);
    }
}
