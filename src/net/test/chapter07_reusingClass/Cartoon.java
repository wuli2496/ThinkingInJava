package net.test.chapter07_reusingClass;

import static net.test.util.Print.*;

class Art
{
    Art() {print("Art constructor");}
}

class Drawing extends Art
{
    Drawing() {print("Drawing constructor");}
}

public class Cartoon extends Drawing {
    public static void main(String[] args)
    {
        Cartoon c = new Cartoon();
    }
}
