package net.test.chapter19_enum.Cartoon;

import net.test.util.Generator;

import java.util.Random;

enum CartoonCharacter implements Generator<CartoonCharacter>
{
    SLAPPY, SPANKY, PUNCKY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg)
    {
        System.out.println(rg.next());
    }

    public static void main(String[] args)
    {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++)
        {
            printNext(cc);
        }
    }
}
