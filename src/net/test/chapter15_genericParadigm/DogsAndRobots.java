package net.test.chapter15_genericParadigm;

import net.test.chapter14_classinfo.example.*;
import static net.test.util.Print.*;

class PerformingDog extends  Dog implements Performs
{
    public void speak()
    {
        print("Woof!");
    }

    public void sit()
    {
        print("Sitting");
    }

    public void reproduct()
    {

    }
}

class Robot implements Performs
{
    public void speak()
    {
        print("Click!");
    }

    public void sit()
    {
        print("Clank!");
    }

    public void oilChange()
    {

    }
}

class Communicate
{
    public static <T extends Performs> void perform(T performer)
    {
        performer.speak();
        performer.sit();
    }
}

public class DogsAndRobots {
    public static void main(String[] args)
    {
        PerformingDog d = new PerformingDog();
        Robot r = new Robot();
        Communicate.perform(d);
        Communicate.perform(r);
    }
}
