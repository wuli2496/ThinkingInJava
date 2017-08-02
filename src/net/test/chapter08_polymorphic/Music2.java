package net.test.chapter08_polymorphic;

import static net.test.util.Print.*;

class Stringed extends Instrument
{
    public void play(Note n)
    {
        print("Stringed.play() " + n);
    }
}

class Brass extends Instrument
{
    public void play(Note n)
    {
        print("Brass.play() " + n);
    }
}

