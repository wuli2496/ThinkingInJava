package net.test.chapter10_innerClasses;

import static net.test.util.Print.*;

class Egg
{
    private Yolk y;
    protected class Yolk
    {
        public Yolk()
        {
            print("Egg.Yolk()");
        }
    }
    public Egg()
    {
        print("New Egg()");
        y = new Yolk();
    }
}

public class BigEgg extends Egg{
    public class Yolk
    {
        public Yolk()
        {
            print("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args)
    {
        new BigEgg();
    }
}
