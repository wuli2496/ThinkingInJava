package net.test.chapter07_reusingClass;

import net.test.chapter05_initializeAndCleanup.Demotion;

import static net.test.util.Print.*;

class Cleanser
{
    private String s= "Cleanser";
    public void append(String a) { s += a;}
    public void dilute() {append(" dilute()");}
    public void apply() {append(" apply()");}
    public void scrub() {append(" scrub()");}
    public String toString() {return s;}

    public static void main(String[] args)
    {
        Cleanser c = new Cleanser();
        c.dilute(); c.apply(); c.scrub();
        print(c);
    }
}

public class Detergent extends Cleanser {
    public void scrub()
    {
        append(" Detergent.scrub()");
        super.scrub();
    }

    public void foam() {append(" foam()");}

    public static void main(String[] args)
    {
        Detergent d = new Detergent();
        d.dilute(); d.apply(); d.scrub(); d.foam();
        print(d);
        print("Testing base class:");
        Cleanser.main(args);
    }
}
