package net.test.chapter08_polymorphic;

import static net.test.util.Print.*;

class Grain
{
    public String toString()
    {
        return "Grain";
    }
}

class Wheat extends Grain
{
    public String toString()
    {
        return "Wheat";
    }
}

class Mill
{
    Grain process()
    {
        return new Grain();
    }
}

class WheatMill
{
    Wheat process()
    {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args)
    {
        Mill m = new Mill();
        Grain g = m.process();
        print(m);

        WheatMill wm = new WheatMill();
        Wheat w = wm.process();
        print(w);
    }
}
