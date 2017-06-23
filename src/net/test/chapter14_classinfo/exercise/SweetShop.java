package net.test.chapter14_classinfo.exercise;

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
        String s = SweetShop.class.getName();
        String pack = s.substring(0, s.lastIndexOf('.'));
        StringBuilder sb = new StringBuilder(pack);
        sb.append(".");
        sb.append(args[0]);
        Class c = null;
        try {
            c = Class.forName(sb.toString());
        } catch (ClassNotFoundException e) {
            print(sb.toString() + " not found");
        }
    }
}
