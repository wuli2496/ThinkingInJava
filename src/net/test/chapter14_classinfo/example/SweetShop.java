package net.test.chapter14_classinfo.example;

/**
 * Created by John on 2017/6/23.
 */
import static net.test.util.Print.*;

class Candy
{
    static {
        print("Loading Candy");
    }
}

class Gum
{
    static {
        print("Loading Gum");
    }
}

class Cookie
{
    static {
        print("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args)
    {
        print("inside main");
        new Candy();
        print("After creating Candy");
        try {
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            print("Couldn't find Gum");
        }

        print("After Class.forName(\"Gum\"");
        new Cookie();
        print("After creating Cookie");
    }
}
