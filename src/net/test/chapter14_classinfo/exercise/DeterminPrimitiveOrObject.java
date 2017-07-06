package net.test.chapter14_classinfo.exercise;

/**
 * Created by John on 2017/6/25.
 */
import static net.test.util.Print.*;

public class DeterminPrimitiveOrObject {
    public static void main(String[] args)
    {
        char[] chAr = new char[10];
        print("chAr is array?" + chAr.getClass().isArray());
        print("chAr is primitive?" + chAr.getClass().isPrimitive());
    }
}
