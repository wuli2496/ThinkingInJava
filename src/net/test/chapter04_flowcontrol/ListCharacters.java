package net.test.chapter04_flowcontrol;

import static net.test.util.Print.*;

public class ListCharacters {
    public static void main(String[] args)
    {
        for (char c = 0; c < 128; c++)
        {
            if (Character.isLowerCase(c))
            {
                print("value: " + (int)c + " character: " + c);
            }
        }
    }
}
