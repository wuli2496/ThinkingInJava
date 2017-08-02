package net.test.chapter08_polymorphic.music3;

import net.test.chapter08_polymorphic.Note;
import static net.test.util.Print.*;

class Instrument
{
    void play(Note n)
    {
        print("Instrument.play() " + n);
    }

    String what()
    {
        return "Instrument";
    }

    void adjust()
    {
        print("Adjusting Instrument");
    }
}


class Wind extends Instrument
{
    void play(Note n)
    {
        print("Wind.play() " + n);
    }

    String what()
    {
        return "Wind";
    }

    void adjust()
    {
        print("Adjusting Wind");
    }
}

class Percussion extends Instrument
{
    void play(Note n)
    {
        print("Percussion.play() " + n);
    }

    String what()
    {
        return "Percussion";
    }

    void adjust()
    {
        print("Adjusting Percussion");
    }
}

class Stringed extends Instrument
{
    void play(Note n)
    {
        print("Stringed.play() " + n);
    }

    String what()
    {
        return "Stringed";
    }

    void adjust()
    {
        print("Adjusting Stringed");
    }
}

class Brassed extends Instrument
{
    void play(Note n)
    {
        print("Brassed.play() " + n);
    }

    String what()
    {
        return "Brassed";
    }

    void adjust()
    {
        print("Adjusting Brassed");
    }
}

class Woodwind extends Instrument
{
    void play(Note n)
    {
        print("Woodwind.play() " + n);
    }

    String what()
    {
        return "Woodwind";
    }

    void adjust()
    {
        print("Adjusting Woodwind");
    }
}

class Base
{
    void f()
    {
        g();
    }

    void g()
    {
        print("Base.g()");
    }
}

class Derived extends Base
{
    @Override
    void g()
    {
        print("Derived.g()");
    }
}
public class Music3 {
    public static void tune(Instrument i)
    {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e)
    {
        for (Instrument i : e)
        {
            tune(i);
        }
    }
    public static void main(String[] args)
    {
        Instrument[] orchestra = {new Wind(), new Percussion(), new Stringed(), new Brassed(), new Woodwind()};
        tuneAll(orchestra);

        Base b = new Derived();
        b.f();
    }
}
