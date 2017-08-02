package net.test.chapter08_polymorphic;

import static net.test.util.Print.*;

public class Wind extends Instrument {
    public void play(Note n)
    {
        print("Wind.play() " + n);
    }
}
