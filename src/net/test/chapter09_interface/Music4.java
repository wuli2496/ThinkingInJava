package net.test.chapter09_interface;

import static net.test.util.Print.*;
import net.test.chapter08_polymorphic.Note;
import org.omg.PortableInterceptor.INACTIVE;

abstract class Instrument
{
    private int i;
    public abstract void play(Note n);
    public String what() {return "Instrument";}
    public abstract void adjust();
}

class Wind extends Instrument
{
    public void play(Note n)
    {
        print("Wind.play() " + n);
    }

    public String what()
    {
        return "Wind";
    }

    public void adjust()
    {

    }
}

class Percussion extends Instrument
{
    public void play(Note n)
    {
        print("Percussion.play() " + n);
    }

    public String what()
    {
        return "Percussion";
    }

    public void adjust() {}
}

class Stringed extends Instrument
{
    public void play(Note n)
    {
        print("Stringed.play() " + n);
    }

    public String what()
    {
        return "Stringed";
    }

    public void adjust() {}
}

class Brass extends Wind
{
    public void play(Note n)
    {
        print("Brass.play() " + n);
    }

    public void adjust() {print("Brass.adjust()");}
}

class Woodwind extends Wind
{
    public void play(Note n)
    {
        print("Woodwind.play() " + n);
    }

    public String what()
    {
        return "Woodwind";
    }
}

public class Music4 {
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
        Instrument[] instruments = {new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind()};
        tuneAll(instruments);

    }
}
