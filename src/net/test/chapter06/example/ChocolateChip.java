package net.test.chapter06.example;

import net.test.chapter06.example.subexample.Cookie;
import static net.test.util.Print.*;

/**
 * Created by John on 2017/4/8.
 */
public class ChocolateChip extends Cookie{
    public ChocolateChip()
    {
        print("ChocolateChip constructor");
    }

    public void chomp()
    {
        bite();
    }

    public static void main(String[] args)
    {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }
}
