package net.test.chapter06.example;

/**
 * Created by John on 2017/4/8.
 */
public class Sundae {
    private Sundae() {}

    static Sundae makeSundae()
    {
        return new Sundae();
    }
}
